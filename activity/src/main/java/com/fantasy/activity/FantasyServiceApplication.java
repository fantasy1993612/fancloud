package com.fantasy.activity;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiangming
 * @date: 2020/1/30 8:17 PM
 * @describtion: 启动类
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableCaching
@EnableAsync
@EnableSwagger2Doc
public class FantasyServiceApplication {

    @Value("${server.port}")
    String port;


    public static void main(String[] args){
        SpringApplication.run(FantasyServiceApplication.class,args);
    }

}
