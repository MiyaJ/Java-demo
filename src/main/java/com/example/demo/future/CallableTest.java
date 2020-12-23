package com.example.demo.future;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.*;

/**
 * @author Caixiaowei
 * @ClassName FutrueTest
 * @Description
 * @createTime 2020/12/15 14:23
 */
@Slf4j
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        log.info("创建线程池");
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Callable<String> callable = () ->{
            log.info("子线程开始执行");
            Thread.sleep(3000);
            return "hello callable!";
        };

        log.info("提交 callable 到线程池");
        Future<String> result = executor.submit(callable);

        log.info("子线程运行结果: {}", result.get());
        log.info("所有任务执行完毕");

        executor.shutdown();

    }

}
