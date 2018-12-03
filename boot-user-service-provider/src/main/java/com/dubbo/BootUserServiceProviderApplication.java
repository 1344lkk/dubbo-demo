package com.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

/**
 * springBoot和dubbo整合的三种方式：
 * 1.导入dubbo-starter,在application.properties中配置属性，使用@Service注解【暴露服务】和使用@Reference【引用服务】
 * 2.保留dubbo.xml配置文件，导入dubbo-starter，使用@ImportResource导入dubbo.xml配置文件
 * 3.使用注解api的方式，创建dubbo配置类，将每一个组件都注入到spring容器中
 */

@SpringBootApplication
//@EnableDubbo //开启基于注解的dubbo功能
//@ImportResource(locations = "classpath:provider.xml")
@DubboComponentScan(basePackages = "com.dubbo") //配置dubbo的扫描基础包
@EnableHystrix //启用服务容错
public class BootUserServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootUserServiceProviderApplication.class, args);
	}
}
