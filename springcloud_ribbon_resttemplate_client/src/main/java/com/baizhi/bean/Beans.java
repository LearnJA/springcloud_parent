package com.baizhi.bean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Beans {
    @Bean
    @LoadBalanced //UnknownHostException: HELLO-SERVICE  这个注解两个作用 1.用来解决服务的负载均衡问题 2.解决以上异常问题
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
