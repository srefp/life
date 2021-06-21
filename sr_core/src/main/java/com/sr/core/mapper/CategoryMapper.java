package com.sr.core.mapper;

import com.sr.core.pojo.CoreCategory;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lkj
 * @date 2021/05/02
 */
public interface CategoryMapper {
    
    /**
     * 批量增加PlanCategory
     * @param planCategories PlanCategory数组
     * @return 是否批量增加成功
     */
    int insertBatch(List<CoreCategory> planCategories);
    
}
