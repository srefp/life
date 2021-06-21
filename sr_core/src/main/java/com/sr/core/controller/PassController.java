package com.sr.core.controller;

import com.sr.core.pojo.CoreMap;
import com.sr.core.service.PassService;
import com.sr.core.common.Result;
import com.sr.core.controller.base.BaseController;
import com.sr.core.vo.PassVO;
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
@Api("密码接口")
@RequestMapping("/password")
public class PassController extends BaseController {

    @Autowired
    private PassService passService;

    /**
     * 增加一条密码
     *
     * @param passVO 账号密码对象
     * @return 是否增加成功
     */
    @ApiOperation("增加一条密码")
    @PostMapping
    public Result insert(@RequestBody PassVO passVO, HttpServletRequest request) {
        Long userId = getUserId(request);
        int addColumnNum = passService.insert(passVO, userId);
        if (addColumnNum == 1) {
            return Result.success("增加账号密码成功");
        } else {
            return Result.error("增加账号密码失败");
        }
    }

    /**
     * 批量增加账号密码
     * @param coreMaps 账号密码数组
     * @return 是否批量增加成功
     */
    @ApiOperation("批量增加账号密码")
    @PostMapping("/batch")
    public Result insertBatch(@RequestBody CoreMap[] coreMaps) {
        int addColumnNum = passService.insertBatch(coreMaps);
        if (addColumnNum == coreMaps.length) {
            return Result.success("批量增加账号密码成功");
        } else {
            return Result.error("批量增加账号密码失败");
        }
    }

    /**
     * 删除一条密码
     *
     * @param id 主键ID
     * @return 是否删除成功
     */
    @ApiOperation("删除一条账号密码")
    @DeleteMapping
    public Result delete(@RequestParam Long id) {
        int deleteColumnNum = passService.delete(id);
        if (deleteColumnNum >= 1) {
            return Result.success("删除账号密码成功");
        } else {
            return Result.error("删除账号密码失败");
        }
    }

    /**
     * 修改一条账号密码
     *
     * @param passVO 账号密码对象
     * @return 是否修改成功
     */
    @ApiOperation("修改一条账号密码")
    @PutMapping
    public Result update(@RequestBody PassVO passVO) {
        int updateColumnNum = passService.update(passVO);
        if (updateColumnNum >= 1) {
            return Result.success("修改账号密码成功");
        } else {
            return Result.error("修改账号密码失败");
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
        List<PassVO> coreMaps = passService.selectByParams(params);
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
        return passService.selectByParamsWithPage(params);
    }

}
