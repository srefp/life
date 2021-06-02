package com.life.task.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

/**
 * @author lkj
 * @date 2021/5/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse {

    private Integer total;

    private Integer filtered;

    private List<?> data;
}
