package com.life.task.mapper;

import com.life.task.pojo.Setting;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author lkj
 * @date 2021/06/01
 */
public interface SettingMapper extends Mapper<Setting> {
    
    /**
     * 批量增加Setting
     * @param settings Setting数组
     * @return 是否批量增加成功
     */
    int insertBatch(List<Setting> settings);


    List<Setting> selectByParams(@Param("params") Map<String, Object> params);
}
