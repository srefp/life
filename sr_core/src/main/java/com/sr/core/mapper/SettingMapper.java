package com.sr.core.mapper;

import com.sr.core.pojo.UserSetting;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author lkj
 * @date 2021/06/01
 */
public interface SettingMapper {
    
    /**
     * 批量增加Setting
     * @param userSettings Setting数组
     * @return 是否批量增加成功
     */
    int insertBatch(List<UserSetting> userSettings);


    List<UserSetting> selectByParams(@Param("params") Map<String, Object> params);
}
