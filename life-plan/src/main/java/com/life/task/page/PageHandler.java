package com.life.task.page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lkj
 * @date 2021/5/17
 */
public class PageHandler {

    private CountHandler countHandler;

    private ListHandler listHandler;

    private OrderHandler orderHandler;

    public PageHandler(CountHandler countHandler, ListHandler listHandler) {
        super();
        this.countHandler = countHandler;
        this.listHandler = listHandler;
    }

    public PageHandler(CountHandler countHandler, ListHandler listHandler, OrderHandler orderHandler) {
        this(countHandler, listHandler);
        this.orderHandler = orderHandler;
    }

    public PageResponse handle(PageRequest request) {
        List<?> list = null;
        int count = this.countHandler.count(request);
        if (count > 0) {
            if (this.orderHandler != null) {
                request = this.orderHandler.order(request);
            }
            list = this.listHandler.list(request);
        }

        if (list == null) {
            list = new ArrayList<>();
        }

        return new PageResponse(count, count, list);
    }

    public interface ListHandler {
        List<?> list(PageRequest request);
    }

    public interface CountHandler {
        int count(PageRequest request);
    }

    public interface OrderHandler {
        PageRequest order(PageRequest request);
    }
}
