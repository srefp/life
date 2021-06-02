package com.life.task.service;

import com.life.task.common.Result;
import com.life.task.mapper.BillMapper;
import com.life.task.pojo.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author lkj
 * @date 2021/06/01
 */
@Service
public class BillService {

    @Autowired
    private BillMapper billMapper;

    /**
     * 批量增加Bill
     *
     * @param bills Bill数组
     * @return 是否批量增加成功
     */
    public int insertBatch(List<Bill> bills) {
        return billMapper.insertBatch(bills);
    }

    /**
     * 根据条件查询账单列表
     *
     * @param params 查询条件
     * @return 账单列表
     */
    public List<Bill> selectByParams(Map<String, Object> params) {
        return billMapper.selectByParams(params);
    }

    /**
     * 根据参数进行分页查询
     *
     * @param params   参数
     * @param offset   偏移量
     * @param pageSize 页面大小
     * @return 查询的数据
     */
    public List<Bill> selectByParamsWithPage(
            Map<String, Object> params,
            Integer offset,
            Integer pageSize
    ) {
        List<Bill> bills = billMapper.selectByParamsWithPage(params, offset, pageSize);
        Result result = Result.success(bills);
        return bills;
    }

    /**
     * 根据条件查询数据条数
     *
     * @param params 查询条件
     * @return 查询的数据
     */
    public int count(Map<String, Object> params) {
        return billMapper.count(params);
    }

}