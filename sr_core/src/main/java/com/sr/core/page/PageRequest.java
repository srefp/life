package com.sr.core.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author lkj
 * @date 2021/5/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {

    /** 当前记录起始索引 */
    private Integer pageNum;

    /** 每页显示记录数 */
    private Integer pageSize;

    private Map<String, Object> params;
}
