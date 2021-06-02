package com.life.task.service;

import com.life.task.mapper.SysLogMapper;
import com.life.task.pojo.SysLog;
import com.life.task.pojo.SysUser;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @author lkj
 * @date 2021/5/9
 */
@Service
public class SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Async
    public void save(SysLog sysLog) {
        if (sysLog == null || sysLog.getUserId() == null) {
            return;
        }
        sysLogMapper.save(sysLog);
    }

    @Async
    public void save(Long userId, String module, Boolean flag, String remark) {
        SysLog sysLog = new SysLog();
        sysLog.setFlag(flag);
        sysLog.setUserId(userId);
        sysLog.setModule(module);
        sysLog.setRemark(remark);

        sysLogMapper.save(sysLog);
    }

    public void deleteLogs() {
        Date date = DateUtils.addMonths(new Date(), -3);

    }
}
