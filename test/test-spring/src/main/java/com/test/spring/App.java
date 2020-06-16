package com.test.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@EnableAutoConfiguration
@RestController
@ConfigurationProperties("application.yml")
public class App {
    @Value("${person.name}")
    private String springName;
    @RequestMapping("/")
    public String home(@RequestParam Map param,String name){
        System.out.println(param);
        System.out.println(name);
        System.out.println(springName);
        return "hello world!!";
    }

    @RequestMapping("/put")
    public String home(@RequestBody Map param, HttpServletRequest request){
        System.out.println(param);
        return "hello world!!";
    }

    public static void main(String[] args) {
        System.out.println("hello word!");
        SpringApplication.run(App.class,args);

    }
}
