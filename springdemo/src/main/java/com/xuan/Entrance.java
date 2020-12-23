package com.xuan;

import com.xuan.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Entrance {
	public static void main(String[] args) {
		/**
		 * 这是spring编译完成后新建的模块
		 * 首先需要先测试这个main函数能否在当前环境下正常运行
		 */
		System.out.println("hello springframework");
		System.out.println("中文测试");
		/**
		 * 下面开始使用spring的方式管理自己新建的bean
		 *
		 * 在本模块根目录下的build.gradle中引入spring-context(此模块本身依也赖于spring的其他模块)模块，这个模块可以解析spring的xml文件，生成容器并返回
		 * 新建bean（HelloServiceImpl）
		 * 新建一个xml文件用于配置bean(按照spring规定的方式配置)
		 * 开始使用bean
		 */
		String xmlPath = "D:\\project\\myproject\\spring-framework-5.2.0.RELEASE\\springdemo\\src\\main\\resources\\spring\\spring-config.xml";
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(xmlPath);
		HelloService helloService = (HelloService) applicationContext.getBean("helloService");
		helloService.sayHello("spring demo");
	}
}
