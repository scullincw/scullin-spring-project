package com.scullincw.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        Environment environment = context.getEnvironment();
        System.out.println("application name: " + environment.getProperty("spring.application.name"));
        String username = environment.getProperty("username");
        String userAge  = environment.getProperty("userage");
        System.out.println("username: " + username + ", age: " + userAge);
    }
}
