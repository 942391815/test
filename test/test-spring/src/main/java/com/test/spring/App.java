package com.test.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class App {
    @RequestMapping("/")
    public String home(){
        return "hello world!!";
    }

    public static void main(String[] args) {
        System.out.println("hello word!");
        SpringApplication.run(App.class,args);
    }
}
