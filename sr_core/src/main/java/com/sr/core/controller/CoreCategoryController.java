package com.sr.core.controller;

import com.sr.core.pojo.CoreCategory;
import com.sr.core.service.CoreCategoryService;
import com.sr.core.common.Result;
import com.sr.core.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author lkj
 * @date 2021/06/04
 */
@CrossOrigin
@RestController
@Api("CoreCategory接口")
@RequestMapping("/category")
public class CoreCategoryController extends BaseController {

    @Autowired
    private CoreCategoryService coreCategoryService;

    /**
     * 增加一条CoreCategory
     *
     * @param coreCategory CoreCategory对象
     * @return 是否增加成功
     */
    @ApiOperation("增加一条CoreCategory")
    @PostMapping
    public Result insert(@RequestBody CoreCategory coreCategory, HttpServletRequest request) {
        Long userId = getUserId(request);
        coreCategory.setUserId(userId);
        int addColumnNum = coreCategoryService.insert(coreCategory);
        if (addColumnNum == 1) {
            return Result.success("增加CoreCategory成功");
        } else {
            return Result.error("增加CoreCategory失败");
        }
    }

    /**
     * 批量增加CoreCategory
     * @param coreCategories CoreCategory数组
     * @return 是否批量增加成功
     */
    @ApiOperation("批量增加CoreCategory")
    @PostMapping("/batch")
    public Result insertBatch(@RequestBody CoreCategory[] coreCategories) {
        int addColumnNum = coreCategoryService.insertBatch(coreCategories);
        if (addColumnNum == coreCategories.length) {
            return Result.success("批量增加CoreCategory成功");
        } else {
            return Result.error("批量增加CoreCategory失败");
        }
    }

    /**
     * 删除一条CoreCategory
     *
     * @param coreCategory CoreCategory对象
     * @return 是否删除成功
     */
    @ApiOperation("删除一条CoreCategory")
    @DeleteMapping
    public Result delete(@RequestBody CoreCategory coreCategory) {
        int deleteColumnNum = coreCategoryService.delete(coreCategory);
        if (deleteColumnNum >= 1) {
            return Result.success("删除CoreCategory成功");
        } else {
            return Result.error("删除CoreCategory失败");
        }
    }
    
    /**
     * 修改一条CoreCategory
     *
     * @param coreCategory CoreCategory对象
     * @return 是否修改成功
     */
    @ApiOperation("修改一条CoreCategory")
    @PutMapping
    public Result update(@RequestBody CoreCategory coreCategory) {
        int updateColumnNum = coreCategoryService.updateCoreCategory(coreCategory);
        if (updateColumnNum >= 1) {
            return Result.success("修改CoreCategory成功");
        } else {
            return Result.error("修改CoreCategory失败");
        }
    }

    /**
     * 查看任务列表（不分页）
     *
     * @return Result
     */
    @ApiOperation(value = "列表")
    @GetMapping
    public Result list(
        @RequestParam Map<String, Object> params,
        HttpServletRequest request
    ) {
        Long userId = getUserId(request);
        params.put("userId", userId);
        List<CoreCategory> coreCategories = coreCategoryService.selectByParams(params);
        return Result.success(coreCategories);
    }

    /**
     * 查看任务列表（分页）
     *
     * @return Result
     */
    @ApiOperation(value = "列表")
    @GetMapping(params = { "pageNum", "pageSize" })
    public Result listWithPage(
        @RequestParam Map<String, Object> params,
        HttpServletRequest request
    ) {
        Long userId = getUserId(request);
        params.put("userId", userId);
        return coreCategoryService.selectByParamsWithPage(params);
    }

}
