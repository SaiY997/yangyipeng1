package com.qdc.demoeurekaconsumerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@SpringBootApplication
@EnableDiscoveryClient
public class DemoEurekaConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaConsumerFeignApplication.class, args);
    }

}
