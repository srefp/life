package com.sr.core.advice;

import com.sr.core.annotation.Log;
import com.sr.core.common.StringUtils;
import com.sr.core.pojo.SysLog;
import com.sr.core.service.SysLogService;
import com.sr.core.util.UserUtil;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lkj
 * @date 2021/5/15
 */
@Aspect
@Component
public class LogAdvice {

    @Autowired
    private SysLogService logService;

    @Around("@annotation(com.sr.core.annotation.Log)")
    public Object logSave(ProceedingJoinPoint joinPoint) throws Throwable {
        SysLog sysLog = new SysLog();
        // 设置当前登录用户
        sysLog.setUserId(UserUtil.getLoginUser().getId());
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        Log log = methodSignature.getMethod().getDeclaredAnnotation(Log.class);
        String module = log.value();
        if (StringUtils.isEmpty(module)) {
            ApiOperation apiOperation = methodSignature.getMethod().getDeclaredAnnotation(ApiOperation.class);
            if (apiOperation != null) {
                module = apiOperation.value();
            }
        }

        if (StringUtils.isEmpty(module)) {
            throw new RuntimeException("没有指定日志module");
        }
        sysLog.setModule(module);

        try {
            Object object = joinPoint.proceed();
            sysLog.setFlag(true);
            return object;
        } catch (Exception e) {
            sysLog.setFlag(false);
            sysLog.setRemark(e.getMessage());
            throw e;
        } finally {
            if (sysLog.getUserId() != null) {
                logService.save(sysLog);
            }
        }
    }

}
