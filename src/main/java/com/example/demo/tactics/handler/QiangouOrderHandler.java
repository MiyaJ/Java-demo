package com.example.demo.tactics.handler;

import com.example.demo.tactics.OrderRequest;
import org.springframework.stereotype.Component;

/**
 * @author Caixiaowei
 * @ClassName QiangouOrderHandler
 * @Description 抢购订单处理
 * @createTime 2020/12/8 10:22
 */
@Component
public class QiangouOrderHandler implements OrderHandler{

    public static String TYPE = "QIANG_GOU";

    @Override
    public boolean suppord(OrderRequest request) {
        return QiangouOrderHandler.TYPE.equalsIgnoreCase(request.getType());
    }

    @Override
    public void handle(OrderRequest request) {
        System.out.println("抢购订单处理----");
    }
}
