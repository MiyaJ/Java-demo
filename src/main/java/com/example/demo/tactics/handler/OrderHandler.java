package com.example.demo.tactics.handler;

import com.example.demo.tactics.OrderRequest;

/**
 * @author Caixiaowei
 * @ClassName OderHandler
 * @Description
 * @createTime 2020/12/8 10:20
 */
public interface OrderHandler {

    /**
     * 判断是否支持
     * @param request
     * @return
     */
    boolean suppord(OrderRequest request);

    /**
     * 具体业务处理
     * @param request
     */
    void handle(OrderRequest request);
}
