package com.qdc.demoeurekaserver3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DemoEurekaServer3Application {

    public static void main(String[] args) {

        SpringApplication.run(DemoEurekaServer3Application.class, args);
    }

}
