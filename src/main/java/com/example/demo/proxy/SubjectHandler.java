package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Caixiaowei
 * @ClassName SubjectHandler
 * @Description
 * @createTime 2020/12/7 15:39
 */
public class SubjectHandler implements InvocationHandler {

    private Subject subject;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("向动态代理服务器发送请求---111");
        if (subject == null) {
            subject = new RealSubject();
        }
        subject.request();
        System.out.println("代理服务器响应----333");
        return null;
    }

    public static Subject createProxy() {
        return (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {Subject.class}, new SubjectHandler());
    }
}
