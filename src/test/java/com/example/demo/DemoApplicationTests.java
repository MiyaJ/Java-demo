package com.example.demo;

import com.example.demo.tactics.OrderRequest;
import com.example.demo.tactics.handler.OrderHandler;
import com.example.demo.tactics.handler.TuangouOrderHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private Map<String, OrderHandler> orderHandlerMap;

    @Test
    public void test_tactics() {
        OrderRequest request = new OrderRequest();
        request.setType(TuangouOrderHandler.TYPE);

        for (Map.Entry<String, OrderHandler> entry : orderHandlerMap.entrySet()) {
            OrderHandler orderHandler = entry.getValue();
            if (orderHandler.suppord(request)) {
                orderHandler.handle(request);
            }
        }
    }
}
