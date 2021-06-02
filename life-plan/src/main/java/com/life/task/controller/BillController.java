package com.life.task.controller;

import com.life.task.pojo.Bill;
import com.life.task.service.BillService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lkj
 * @date 2021/6/1
 */
@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService billService;

    /**
     * 批量增加Bill
     *
     * @param bills Bill数组
     * @return 是否批量增加成功
     */
    @PostMapping("/batch")
    public int insertBatch(@RequestBody List<Bill> bills) {
        return billService.insertBatch(bills);
    }

    /**
     * 根据条件查询账单列表
     *
     * @param params 查询条件
     * @return 账单列表
     */
    @GetMapping
    public List<Bill> selectByParams(@RequestParam Map<String, Object> params) {
        Integer pageNum = (Integer) params.get("pageNum");
        Integer pageSize = (Integer) params.get("pageSize");
        if (pageNum != null && pageSize != null) {
            params.remove("pageNum");
            params.remove("pageSize");
            return billService.selectByParamsWithPage(params, pageNum, pageSize);
        }
        return billService.selectByParams(params);
    }

    /**
     * 根据条件查询数据条数
     *
     * @param params 查询条件
     * @return 查询的数据
     */
    public int count(Map<String, Object> params) {
        return billService.count(params);
    }

}
