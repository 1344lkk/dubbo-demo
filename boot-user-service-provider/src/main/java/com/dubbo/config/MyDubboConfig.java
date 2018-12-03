package com.dubbo.config;

import com.alibaba.dubbo.config.*;
import dubbo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lkk
 * @version V1.0
 * @Description: 基于api注解方式的dubbo配置类
 * @date 2018/11/22/11:36
 */
@Configuration
public class MyDubboConfig {

    /**
     * 配置dubbo的当前应用名
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service-provider");
        return applicationConfig;
    }

    /**
     * 配置注册中心
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }

    /**
     * 配置通讯协议
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    @Bean
    public ServiceConfig<UserService> userServiceConfig(UserService userService) {
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<UserService>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        serviceConfig.setVersion("1.0.0");

//        MethodConfig methodConfig = new MethodConfig();
//        methodConfig.setName("getUserAddressList");
//        methodConfig.setTimeout(5000);
//        List<MethodConfig> methodConfigList = new ArrayList<>();
//        methodConfigList.add(methodConfig);
//
//        serviceConfig.setMethods(methodConfigList);

        return serviceConfig;
    }


}
