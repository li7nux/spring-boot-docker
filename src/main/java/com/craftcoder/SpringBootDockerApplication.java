package com.craftcoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class SpringBootDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDockerApplication.class, args);
    }

    @RequestMapping("/")
    public Map<String, String> index() {
        Map<String, String> module = new HashMap<>();
        module.put("app", "spring-boot-docker-app");
        module.put("time", new Date().toString());
        return module;
    }

}
