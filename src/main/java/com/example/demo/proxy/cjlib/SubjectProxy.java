package com.example.demo.proxy.cjlib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Caixiaowei
 * @ClassName SubjectProxy
 * @Description
 * @createTime 2020/12/7 16:12
 */
public class SubjectProxy implements MethodInterceptor {

    private Object target;
    /**
     * 创建代理对象
     *
     * @param target 目标对象
     * @return
     * @author Caixiaowei
     * @updateTime 2020/12/7 16:14
     */
    public Object getInstance(Object target) {
        System.out.println("创建代理对象");
        this.target = target;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("向代理对象发送请求----");
        methodProxy.invokeSuper(o, objects);
        System.out.println("代理对象响应----");
        return null;
    }
}
