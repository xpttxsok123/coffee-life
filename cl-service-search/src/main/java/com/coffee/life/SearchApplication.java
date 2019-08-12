package com.coffee.life;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jay
 * @version 1.0
 **/
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages={"com.coffee.life.search.model"})//扫描接口
@ComponentScan(basePackages={"com.coffee.life.search"})//扫描本项目下的所有类
@ComponentScan(basePackages={"com.coffee.life.framework"})//扫描common下的所有类
public class SearchApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SearchApplication.class, args);
    }

}
