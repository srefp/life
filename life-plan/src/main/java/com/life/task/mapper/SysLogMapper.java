package com.life.task.mapper;

import com.life.task.pojo.SysLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author lkj
 * @date 2021/05/17
 */
public interface SysLogMapper extends Mapper<SysLog> {

    int save(SysLog sysLog);

    int count(@Param("params") Map<String, Object> params);

    List<SysLog> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset,
                       @Param("limit") Integer limit);

    @Delete("delete from sys_log where create_time <= #{time}")
    int deleteLogs(String time);

    /**
     * 批量增加SysLog
     *
     * @param sysLogs SysLog数组
     * @return 是否批量增加成功
     */
    int insertBatch(List<SysLog> sysLogs);

}
