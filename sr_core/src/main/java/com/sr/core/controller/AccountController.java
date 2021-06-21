package com.sr.core.controller;

import com.sr.core.pojo.CoreAccount;
import com.sr.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author lkj
 * @date 2021/6/1
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 批量增加CoreAccount
     *
     * @param accounts CoreAccount数组
     * @return 是否批量增加成功
     */
    @PostMapping("/batch")
    public int insertBatch(@RequestBody List<CoreAccount> accounts) {
        return accountService.insertBatch(accounts);
    }

    /**
     * 根据条件查询账单列表
     *
     * @param params 查询条件
     * @return 账单列表
     */
    @GetMapping
    public List<CoreAccount> selectByParams(@RequestParam Map<String, Object> params) {
        Integer pageNum = (Integer) params.get("pageNum");
        Integer pageSize = (Integer) params.get("pageSize");
        if (pageNum != null && pageSize != null) {
            params.remove("pageNum");
            params.remove("pageSize");
            return accountService.selectByParamsWithPage(params, pageNum, pageSize);
        }
        return accountService.selectByParams(params);
    }

    /**
     * 根据条件查询数据条数
     *
     * @param params 查询条件
     * @return 查询的数据
     */
    public int count(Map<String, Object> params) {
        return accountService.count(params);
    }

}
