package com.example.demo.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Caixiaowei
 * @ClassName ThreadPoolDemo
 * @Description 线程池
 * @createTime 2021/1/12 11:04
 */
@RestController
@RequestMapping("/thread-pool")
@Slf4j
public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
//        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        printStatus(threadPool);
        for (int i = 0; i < 10000000; i++) {
            threadPool.execute(() -> {
                String str = IntStream.rangeClosed(1, 1000000)
                        .mapToObj(__ -> "a")
                        .collect(Collectors.joining("")) + UUID.randomUUID().toString();
                try {
                    TimeUnit.HOURS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println(str);
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
    }

    private static void printStatus(ThreadPoolExecutor threadPool) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() ->{
            log.info("=======================");
            log.info("pool size: {}", threadPool.getPoolSize());
            log.info("active threads: {}", threadPool.getActiveCount());
            log.info("number of tasks completed: {}", threadPool.getCompletedTaskCount());
            log.info("number of tasks in queue: {}", threadPool.getQueue().size());
        }, 0, 1, TimeUnit.SECONDS);
    }
}
