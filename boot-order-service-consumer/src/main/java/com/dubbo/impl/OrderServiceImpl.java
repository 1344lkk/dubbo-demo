package com.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import dubbo.bean.UserAddress;
import dubbo.service.OrderService;
import dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lkk
 * @version V1.0
 * @Description:
 * @date 2018/10/11/15:52
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{

//    @Autowired
    //此注解会远程调用服务提供者service接口
    //url属性表示直连服务提供者，不通过注册中心 url = "127.0.0.1:20880"
    @Reference(check = false, stub = "dubbo.service.stub.UserServiceStub",timeout = 2000)
    UserService userService;

    @HystrixCommand(fallbackMethod = "error")
    public List<UserAddress> initOrder(String userId) {
        return userService.getUserAddressList(userId);
    }

    public List<UserAddress> error(String userId) {
        List<UserAddress> errorList = new ArrayList<UserAddress>();
        UserAddress address1 = new UserAddress(null, "数据错误", "", "数据错误", "数据错误", "数据错误");
        errorList.add(address1);
        return errorList;
    }
}
