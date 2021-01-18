package com.example.demo.lambda;

import com.example.demo.faker.UserInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.function.*;

/**
 * @author Caixiaowei
 * @ClassName LambdaDemo
 * @Description 函数式接口--lambda 案例
 * @createTime 2021/1/18 19:06
 */
@Slf4j
public class LambdaDemo {

    /*************** 内置函数式接口 **************/
    /**
     * predicate    test(T t) 判断真伪
     * Comsumer     accept(T t) 消费消息
     * Function     R apply(T t) 转换, 将t 转换为R
     * Supplier     T get() 生产消息
     *
     */
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("小明", 18);

        // 判断true / false
        Predicate<Integer> pridcate = x -> x > 20;
        log.info("小明是成年了吗: {}", pridcate.test(userInfo.getAge()));

        // consumer 输出一个值
        Consumer<String> consumer = System.out::println;
        consumer.accept("我是峡谷小飞象.");

        // function 转换
        Function<UserInfo, String> function = UserInfo::getName;
        String apply = function.apply(userInfo);
        log.info("function: {}", apply);

        // 生产消息
        Supplier<String> supplier = () -> userInfo.getName();
        String str = supplier.get();
        log.info("supplier: {}", str);

        // 一元操作
        UnaryOperator<Integer> unaryOperator = x -> x + 1;
        Integer apply1 = unaryOperator.apply(2);
        log.info("unaryOperator 一元操作:{} ", apply1);

        // 二元操作
        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
        Integer apply2 = binaryOperator.apply(2, 3);
        log.info("binaryOperator 二元操作: {}", apply2);

        // 自定义接口
        test(() -> "这是一个自定义接口");
    }

    public static void test(Worker worker) {
        String work = worker.work();
        log.info("test: {}", work);
    }

}
