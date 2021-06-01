package com.yin.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//todo why 本地切换分支后代码会跟新
/**
 *远程调用接口
 */
@EnableFeignClients(basePackages= "com.yin.member.feign")
@SpringBootApplication
@EnableDiscoveryClient
public class MemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }

}
