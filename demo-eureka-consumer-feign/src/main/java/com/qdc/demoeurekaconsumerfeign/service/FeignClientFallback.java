package com.qdc.demoeurekaconsumerfeign.service;

import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements UserClient {
    @Override
    public String hello() {
        return "";
    }

    @Override
    public String hello(int sleep_seconds) {
        return "hi,容错保护机制已经启动了！";
    }

}
