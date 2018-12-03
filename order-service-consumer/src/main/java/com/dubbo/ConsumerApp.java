package com.dubbo;

import dubbo.bean.UserAddress;
import dubbo.service.OrderService;
import dubbo.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * @author lkk
 * @version V1.0
 * @Description:
 * @date 2018/10/11/15:23
 */
public class ConsumerApp {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");

//        OrderService orderService = (OrderService) ioc.getBean("orderService");

//        List<UserAddress> ads = orderService.initOrder("11111");

        UserService userService = (UserService) ioc.getBean("userService");

        List<UserAddress> ads = userService.getUserAddressList(null);

        if (ads == null) {
            System.out.println("查询返回为null");
        } else {
            for (UserAddress address : ads){
                System.out.println(address.getUserAddress());
            }
        }
        System.out.println("启动成功！");
        System.in.read();
    }
}
