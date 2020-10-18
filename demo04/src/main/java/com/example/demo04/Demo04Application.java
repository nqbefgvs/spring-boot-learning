package com.example.demo04;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.demo04.mapper")
public class Demo04Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo04Application.class, args);
    }

}
