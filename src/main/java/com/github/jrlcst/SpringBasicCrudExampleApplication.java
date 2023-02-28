package com.github.jrlcst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.github.jrlcst.service", "com.github.jrlcst.controller"})
public class SpringBasicCrudExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBasicCrudExampleApplication.class, args);
    }
}
