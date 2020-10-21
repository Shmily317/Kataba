package com.ufo.kataba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@MapperScan(basePackages ="com.ufo.kataba.dao")//扫描持久层
@EnableTransactionManagement//开启事务管理器
public class KatabaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KatabaApplication.class, args);
    }

}
