package com.dubbo.service.impl;

import dubbo.bean.UserAddress;
import dubbo.service.OrderService;
import dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lkk
 * @version V1.0
 * @Description:
 * @date 2018/10/11/15:52
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{

    @Autowired
    UserService userService;

    public List<UserAddress> initOrder(String userId) {
        return userService.getUserAddressList(userId);
    }
}
