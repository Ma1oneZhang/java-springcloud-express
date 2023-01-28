package com.express;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zzy
 */
@SpringBootApplication
@EnableEurekaClient
public class MenuApplication {
    public static void main(String[] args) {
        SpringApplication.run(MenuApplication.class);
    }
}