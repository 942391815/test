package com.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@EnableAutoConfiguration
@Configuration
@Controller
public class App {
    @RequestMapping("/")
    public String home(@RequestParam Map param, String name){
        System.out.println(param);
        System.out.println(name);
        return "hello world!!";
    }

    @RequestMapping("/put")
    public String home(@RequestBody Map param){
        System.out.println(param);
        return "hello world!!";
    }

    public static void main(String[] args) {
        System.out.println("hello word!");
        SpringApplication.run(App.class,args);

    }
    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public User getALibrarianInfo() {
        return userService.selectLibrarian(1);
    }
}
