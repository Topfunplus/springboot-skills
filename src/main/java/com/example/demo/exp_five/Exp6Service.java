package com.example.demo.exp_five;

// 因为加了xml配置文件，所以这里不需要加@Service注解 而且也被注入到spring容器中了
public class Exp6Service {

    public void getServiceId(String id) {
        System.out.println(id);

    }
}
