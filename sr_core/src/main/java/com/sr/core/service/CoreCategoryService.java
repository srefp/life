package com.sr.core.service;


import com.sr.core.mapper.CoreCategoryMapper;
import com.sr.core.common.Result;
import com.sr.core.pojo.CoreCategory;
import org.springframework.beans.factory.annotation.Autowired;
import com.sr.core.page.PageHandler;
import com.sr.core.page.PageRequest;
import com.sr.core.page.PageResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lkj
 * @date 2021/06/04
 */
@Service
public class CoreCategoryService {

    @Autowired
    private CoreCategoryMapper coreCategoryMapper;

    /**
     * 增加一条CoreCategory
     *
     * @param coreCategory CoreCategory对象
     * @return 增加的记录数
     */
    public int insert(CoreCategory coreCategory) {
        return coreCategoryMapper.insert(coreCategory);
    }

    /**
     * 批量增加CoreCategory
     *
     * @param coreCategorys CoreCategory数组
     * @return 是否批量增加成功
     */
    public int insertBatch(CoreCategory[] coreCategorys) {
        List<CoreCategory> collect = Arrays.stream(coreCategorys).collect(Collectors.toList());
        return coreCategoryMapper.insertBatch(collect);
    }

    /**
     * 删除一条CoreCategory
     *
     * @param coreCategory CoreCategory对象
     * @return 删除的记录数
     */
    public int delete(CoreCategory coreCategory) {
        return coreCategoryMapper.delete(coreCategory);
    }

    /**
     * 更新一条CoreCategory
     *
     * @param coreCategory CoreCategory对象
     * @return 更新的记录数
     */
    public int updateCoreCategory(CoreCategory coreCategory) {
        return coreCategoryMapper.update(coreCategory);
    }

    /**
     * 根据条件查询CoreCategory列表
     *
     * @param params 查询条件
     * @return CoreCategory列表
     */
    public List<CoreCategory> selectByParams(Map<String, Object> params) {
        return coreCategoryMapper.selectByParams(params);
    }

    /**
     * 根据条件查询数据条数
     *
     * @param params 查询条件
     * @return 满足条件的数据记录数
     */
    public int count(Map<String, Object> params) {
        return coreCategoryMapper.count(params);
    }

    /**
     * 根据参数进行分页查询
     *
     * @param params 参数
     * @return 查询的数据
     */
    public Result selectByParamsWithPage(
            Map<String, Object> params
    ) {
        int pageNum = (int) params.get("pageNum");
        int pageSize = (int) params.get("pageSize");
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, params);
        PageResponse pageResponse = new PageHandler(
                req -> coreCategoryMapper.count(req.getParams()),
                req -> coreCategoryMapper.selectByParamsWithPage(params, (req.getPageNum() - 1) * req.getPageSize(), req.getPageSize())
        ).handle(pageRequest);

        Result result = Result.success();
        result.put("total", pageResponse.getTotal());
        result.put("data", pageResponse.getData());
        return result;
    }

}
