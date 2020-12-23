package com.example.demo.proxy;

/**
 * @author Caixiaowei
 * @ClassName ProxySubject
 * @Description 代理类
 * @createTime 2020/12/7 15:06
 */
public class ProxySubject implements Subject{

    private Subject realSubject;

    @Override
    public void request() {
        System.out.println("代理服务发送请求----111");
        if (realSubject == null) {
            realSubject = new RealSubject();

            System.out.println("代理对象向真实对象发送请求----222");
            realSubject.request();
        }
    }
}
