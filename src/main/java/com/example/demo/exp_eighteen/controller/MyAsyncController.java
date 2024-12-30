package com.example.demo.exp_eighteen.controller;


import com.example.demo.exp_eighteen.MyAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.Future;

@Controller
public class MyAsyncController {


    @Autowired
    private MyAsyncService myAsyncService;


    @GetMapping("/sendSMS")
    public String sendSMS() throws Exception {
        myAsyncService.sendSMS_1();
        myAsyncService.sendSMS_2();
        return "success";
    }


    @GetMapping("/static")
    public String staticPage() {
        Long startTime = System.currentTimeMillis();
        int total = 0;
        try {
            Future<Integer> futureA = myAsyncService.processA();
            Future<Integer> futureB = myAsyncService.processB();
            total = futureA.get() + futureB.get();
        } catch (Exception e) {
            System.out.println("异步任务数据统计汇总异常" + e.getMessage());
        }
        System.out.println("异步任务数据统计汇总结果:" + total);
        Long endTime = System.currentTimeMillis();
        System.out.println("主流程耗时:" + (endTime - startTime));
        return "success";
    }
}
