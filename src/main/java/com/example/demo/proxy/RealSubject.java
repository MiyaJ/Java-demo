package com.example.demo.proxy;

/**
 * @author Caixiaowei
 * @ClassName RealSubject
 * @Description 真实类
 * @createTime 2020/12/7 15:06
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("真实对象响应请求---333");
    }
}
