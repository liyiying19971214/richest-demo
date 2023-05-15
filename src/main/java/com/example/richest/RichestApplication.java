package com.example.richest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//扫描里面的mapper
@MapperScan("com.example.richest.**.mapper")
@SpringBootApplication
public class RichestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RichestApplication.class, args);
    }

}
