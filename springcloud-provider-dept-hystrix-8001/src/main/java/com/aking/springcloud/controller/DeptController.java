package com.aking.springcloud.controller;

/**
 * @author AkingBb
 * @date 2021/4/6 17:42
 */

import com.aking.springcloud.pojo.Dept;
import com.aking.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供restful服务
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        Dept dept=deptService.queryById(id);
        if (dept==null){
            throw new RuntimeException("id=>"+id+",不存在该用户或信息未找到！");
        }
        return dept;
    }

    /**
     * 备选方法
     */
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id=>"+id+"没有对应信息，null--@Hystrix")
                .setDb_source("no this database in MySQL");
    }
}
