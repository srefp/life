package com.life.task.mapper;

import com.life.task.pojo.PlanCategory;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lkj
 * @date 2021/05/02
 */
public interface PlanCategoryMapper extends Mapper<PlanCategory> {
    
    /**
     * 批量增加PlanCategory
     * @param planCategories PlanCategory数组
     * @return 是否批量增加成功
     */
    int insertBatch(List<PlanCategory> planCategories);
    
}
