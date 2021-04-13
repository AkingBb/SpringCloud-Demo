package com.aking.springcloud.service;

import com.aking.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author AkingBb
 * @date 2021/4/13 10:05
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            public Dept queryById(Long id) {
                return new Dept().setDeptno(id).setDname("id=>"+id+",客户端提供了降级信息，该服务暂时关闭");
            }

            public List<Dept> queryAll() {
                return null;
            }

            public Boolean addDept(Dept dept) {
                return null;
            }
        };
    }
}
