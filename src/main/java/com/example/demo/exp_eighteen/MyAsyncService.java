package com.example.demo.exp_eighteen;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class MyAsyncService {

    @Async
    public void sendSMS_1() throws Exception {
        System.out.println("任务1:发送短信开始");
        Thread.sleep(5000);
        System.out.println("任务2:发送短信结束");
    }


    @Async
    public void sendSMS_2() throws Exception {
        System.out.println("任务3:调用短信验证码业务方法...");
        long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        long endTime = System.currentTimeMillis();
        System.out.println("任务4:短信业务执行完成耗时：" + (endTime - startTime));
    }

    @Async
    public Future<Integer> processA() throws Exception {
        System.out.println("开始分析并统计业务A数据...");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(4000);
        // 模拟定义一个假的统计结果
        int count = 123456;
        Long endTime = System.currentTimeMillis();
        System.out.println("业务A数据统计耗时：" + (endTime - startTime));
        return new AsyncResult<Integer>(count);
    }

    @Async
    public Future<Integer> processB() throws Exception {
        System.out.println("开始分析并统计业务B数据...");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        // 模拟定义一个假的统计结果
        int count = 654321;
        Long endTime = System.currentTimeMillis();
        System.out.println("业务B数据统计耗时：" + (endTime - startTime));
        return new AsyncResult<Integer>(count);
    }
}
