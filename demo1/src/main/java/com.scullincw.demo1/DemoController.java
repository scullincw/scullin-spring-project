package com.scullincw.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/echo")
    public String echo() {
        return appName + " echoing, discovered by Nacos";
    }
}
