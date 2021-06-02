package com.life.task.mapper;

import com.life.task.pojo.PlanLabel;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lkj
 * @date 2021/05/02
 */
public interface PlanLabelMapper extends Mapper<PlanLabel> {
    
    /**
     * 批量增加PlanLabel
     * @param planLabels PlanLabel数组
     * @return 是否批量增加成功
     */
    int insertBatch(List<PlanLabel> planLabels);
    
}
