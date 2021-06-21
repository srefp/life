package com.sr.core.controller;

import com.sr.core.pojo.CoreMap;
import com.sr.core.service.CoreMapService;
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
 * @date 2021/06/09
 */
@CrossOrigin
@RestController
@Api("CoreMap接口")
@RequestMapping("/map")
public class CoreMapController extends BaseController {

    @Autowired
    private CoreMapService coreMapService;

    /**
     * 增加一条CoreMap
     *
     * @param coreMap CoreMap对象
     * @return 是否增加成功
     */
    @ApiOperation("增加一条CoreMap")
    @PostMapping
    public Result insert(@RequestBody CoreMap coreMap, HttpServletRequest request) {
        Long userId = getUserId(request);
        coreMap.setUserId(userId);
        int addColumnNum = coreMapService.insert(coreMap);
        if (addColumnNum == 1) {
            return Result.success("增加CoreMap成功");
        } else {
            return Result.error("增加CoreMap失败");
        }
    }

    /**
     * 批量增加CoreMap
     * @param coreMaps CoreMap数组
     * @return 是否批量增加成功
     */
    @ApiOperation("批量增加CoreMap")
    @PostMapping("/batch")
    public Result insertBatch(@RequestBody CoreMap[] coreMaps) {
        int addColumnNum = coreMapService.insertBatch(coreMaps);
        if (addColumnNum == coreMaps.length) {
            return Result.success("批量增加CoreMap成功");
        } else {
            return Result.error("批量增加CoreMap失败");
        }
    }

    /**
     * 删除一条CoreMap
     *
     * @param id 主键ID
     * @return 是否删除成功
     */
    @ApiOperation("删除一条CoreMap")
    @DeleteMapping
    public Result delete(@RequestParam Long id) {
        int deleteColumnNum = coreMapService.delete(id);
        if (deleteColumnNum >= 1) {
            return Result.success("删除CoreMap成功");
        } else {
            return Result.error("删除CoreMap失败");
        }
    }
    
    /**
     * 修改一条CoreMap
     *
     * @param coreMap CoreMap对象
     * @return 是否修改成功
     */
    @ApiOperation("修改一条CoreMap")
    @PutMapping
    public Result update(@RequestBody CoreMap coreMap) {
        int updateColumnNum = coreMapService.update(coreMap);
        if (updateColumnNum >= 1) {
            return Result.success("修改CoreMap成功");
        } else {
            return Result.error("修改CoreMap失败");
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
        List<CoreMap> coreMaps = coreMapService.selectByParams(params);
        return Result.success(coreMaps);
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
        return coreMapService.selectByParamsWithPage(params);
    }

}
