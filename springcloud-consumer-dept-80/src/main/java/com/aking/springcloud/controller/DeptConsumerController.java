package com.aking.springcloud.controller;

import com.aking.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author AkingBb
 * @date 2021/4/7 11:32
 */
@RestController
public class DeptConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    // private static final String REST_URL_PREFIX="http://localhost:8001";
    /**
     * 通过Ribbon实现时 url应是一个变量，通过服务名访问
     */
    private static final String REST_URL_PREFIX="http://SPRING-CLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/add")
    public Boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
}
