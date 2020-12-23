package com.example.demo.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author Caixiaowei
 * @ClassName FutureTaskTest
 * @Description
 * @createTime 2020/12/15 18:49
 */
@Slf4j
public class FutureTaskTest {

    /**
     * 上班准备工作:
     *  开电脑-->idea
     *  擦桌子
     * @param args
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log.info("开始上班的准备工作");

        log.info("创建线程池");
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        log.info("提交开电脑任务到线程池");
        Future<String> computerFuture = executorService.submit(new ComputerTask());

        log.info("提交擦桌子任务到线程池");
        Future<String> deskFuture = executorService.submit(new DeskTask());

        log.info(computerFuture.get());
        log.info(deskFuture.get());

        if (computerFuture.isDone() && deskFuture.isDone()) {
            log.info("准备工作完成, 开启一天的工作吧!");
        }

        executorService.shutdown();
    }

    /**
     * 开电脑任务
     */
    static class ComputerTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            log.info("打开电脑, 运行idea");
            return "开机完成!";
        }
    }

    /**
     * 擦桌子任务
     */
    static class DeskTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            log.info("开始清理办公桌");
            return "桌面清理完成!";
        }
    }
}
