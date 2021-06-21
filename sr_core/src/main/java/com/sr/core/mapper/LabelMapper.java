package com.sr.core.mapper;

import com.sr.core.pojo.CoreLabel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lkj
 * @date 2021/05/02
 */
public interface LabelMapper {
    
    /**
     * 批量增加PlanLabel
     * @param labels PlanLabel数组
     * @return 是否批量增加成功
     */
    int insertBatch(List<CoreLabel> labels);
    
}
