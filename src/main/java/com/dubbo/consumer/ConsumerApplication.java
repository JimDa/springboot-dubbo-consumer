package com.dubbo.consumer;

import org.springframework.boot.SpringApplication;

import javax.annotation.PostConstruct;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.HelloService;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConsumerApplication {

    @Reference(version = "1.0.0")
    private HelloService demoService;

    public static void main(String[] args) {

        SpringApplication.run(ConsumerApplication.class, args);
    }

    //    @PostConstruct
//    public void init() {
//    	String sayHello = demoService.sayHello("world");
//    	System.err.println(sayHello);
//    }
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return demoService.sayHello(name);
    }
}
