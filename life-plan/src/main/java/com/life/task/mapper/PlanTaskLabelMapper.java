package com.life.task.mapper;

import com.life.task.pojo.PlanTaskLabel;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lkj
 * @date 2021/05/02
 */
public interface PlanTaskLabelMapper extends Mapper<PlanTaskLabel> {
    
    /**
     * 批量增加PlanTaskLabel
     * @param planTaskLabels PlanTaskLabel数组
     * @return 是否批量增加成功
     */
    int insertBatch(List<PlanTaskLabel> planTaskLabels);
    
}
