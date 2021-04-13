package com.aking.springcloud.controller;

/**
 * @author AkingBb
 * @date 2021/4/6 17:42
 */

import com.aking.springcloud.pojo.Dept;
import com.aking.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 提供restful服务
 */
@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    /**
     * 注册进来的微服务获取一些其中的信息
     */
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取Eureka列表清单
        List<String> services = client.getServices();
        System.out.println("Services=>"+services);

        //得到具体的微服务信息,通过具体的微服务ID
        List<ServiceInstance> instances = client.getInstances("SPRING-CLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\t"+ instance.getPort()+"\t"+ instance.getUri()+"\t"+instance.getServiceId()
            );
        }
        return this.client;
    }
}
