package com.dubbo.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import dubbo.bean.UserAddress;
import dubbo.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Service //这里是dubbo提供的Service注解，目的是将服务提供者的service接口暴露到注册中心
@Component
public class UserServiceImpl implements UserService {

	@HystrixCommand
	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("UserServiceImpl.....old...boot");

		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");

		double random = Math.random();
		if (random > 0.5) {
			System.out.println("random = " + random);
			throw new RuntimeException();
		}
		return Arrays.asList(address1,address2);
	}

}
