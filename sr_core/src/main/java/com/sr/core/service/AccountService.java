package com.sr.core.service;

import com.sr.core.common.Result;
import com.sr.core.mapper.AccountMapper;
import com.sr.core.pojo.CoreAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author lkj
 * @date 2021/06/01
 */
@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 批量增加CoreCoreAccount
     *
     * @param accounts CoreCoreAccount数组
     * @return 是否批量增加成功
     */
    public int insertBatch(List<CoreAccount> accounts) {
        return accountMapper.insertBatch(accounts);
    }

    /**
     * 根据条件查询账单列表
     *
     * @param params 查询条件
     * @return 账单列表
     */
    public List<CoreAccount> selectByParams(Map<String, Object> params) {
        return accountMapper.selectByParams(params);
    }

    /**
     * 根据参数进行分页查询
     *
     * @param params   参数
     * @param offset   偏移量
     * @param pageSize 页面大小
     * @return 查询的数据
     */
    public List<CoreAccount> selectByParamsWithPage(
            Map<String, Object> params,
            Integer offset,
            Integer pageSize
    ) {
        List<CoreAccount> accounts = accountMapper.selectByParamsWithPage(params, offset, pageSize);
        Result result = Result.success(accounts);
        return accounts;
    }

    /**
     * 根据条件查询数据条数
     *
     * @param params 查询条件
     * @return 查询的数据
     */
    public int count(Map<String, Object> params) {
        return accountMapper.count(params);
    }

}