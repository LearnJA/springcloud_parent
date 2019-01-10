package com.baizhi.controller;

import com.baizhi.bean.Beans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/show")
public class ShowHelloController {

    /*//引入LoadBalancerClient 获取注册中心的所有服务对象
    @Autowired
    private LoadBalancerClient loadBalancerClient;*/
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String showHello(String name){
        //1.第一种调用方式  RestTemplate
       /* RestTemplate restTemplate=new RestTemplate();
        String forObject=restTemplate.getForObject("http://192.168.0.37:8989/hello/hello?name=" + name, String.class);
        System.out.println(forObject);
        return forObject;*/

       //2.第二种调用方式   书写调用服务的名称（choose()根据服务名称选择一个可用服务返回一个服务实例）
        /*ServiceInstance serviceInstance=loadBalancerClient.choose("HELLO_SERVICE");
        //serviceInstance.getHost()获取服务主机名
        System.out.println(serviceInstance.getHost());
        //serviceInstance.getPort() 获取服务端口号
        System.out.println(serviceInstance.getPort());
        //创建一个服务调用模型
        RestTemplate restTemplate=new RestTemplate();
        String forObject = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello/hello?name=" + name, String.class);
        */

        //直接通过restTemplate来调用服务
        //第三种方式
        String forObject = restTemplate.getForObject("http://HELLO-SERVICE/hello/hello?name=" + name, String.class);
        return forObject;
    }
}
