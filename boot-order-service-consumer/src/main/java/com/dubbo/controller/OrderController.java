package com.dubbo.controller;

import dubbo.bean.UserAddress;
import dubbo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lkk
 * @version V1.0
 * @Description:
 * @date 2018/11/21/10:21
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("initOrder")
    public List<UserAddress> initOrder(@RequestParam(value = "uid", required = false) String userId) {
        return orderService.initOrder(userId);
    }
}
