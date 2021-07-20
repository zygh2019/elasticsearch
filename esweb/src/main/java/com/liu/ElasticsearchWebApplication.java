package com.liu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author shengbinliu
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.liu"})
public class ElasticsearchWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchWebApplication.class, args);
    }

}
