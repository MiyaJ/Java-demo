package com.example.demo.tactics.handler;

import com.example.demo.tactics.OrderRequest;
import org.springframework.stereotype.Component;

/**
 * @author Caixiaowei
 * @ClassName TuangouOrderHandler
 * @Description 团购订单处理
 * @createTime 2020/12/8 10:21
 */
@Component
public class TuangouOrderHandler implements OrderHandler {

    public static String TYPE = "TUAN_GOU";

    @Override
    public boolean suppord(OrderRequest request) {
        return TuangouOrderHandler.TYPE.equalsIgnoreCase(request.getType());
    }

    @Override
    public void handle(OrderRequest request) {
        System.out.println("团购订单处理----");
    }
}
