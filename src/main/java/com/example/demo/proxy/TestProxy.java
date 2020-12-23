package com.example.demo.proxy;

import com.example.demo.proxy.cjlib.SubjectProxy;

/**
 * @author Caixiaowei
 * @ClassName TestProxy
 * @Description
 * @createTime 2020/12/7 15:10
 */
public class TestProxy {

    public static void main(String[] args) {
        // 静态代理测试
//        Subject proxySubject = new ProxySubject();
//        proxySubject.request();

        // jdk 动态代理测试
//        Subject proxy = SubjectHandler.createProxy();
//        proxy.request();

        // cglib 动态代理测试
        SubjectProxy proxy = new SubjectProxy();
        Subject subject = (Subject) proxy.getInstance(new RealSubject());
        subject.request();
    }
}
