package com.gfo.gfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.gfo.gfo.mapper")
public class GfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GfoApplication.class, args);
    }

}
