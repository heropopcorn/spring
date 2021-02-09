package com.xuan.controller;


import com.xuan.service.HelloService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController implements ApplicationContextAware, BeanNameAware {
	//定义变量用于接收setBeanName方法设置的BeanName
	private String beanName;
	//定义变量用于接收setApplicationContext方法设置的ApplicationContext
	private ApplicationContext applicationContext;
	@Autowired
	private HelloService helloService;

	public void handleRequest() {
		helloService.sayHello("handleRequest");
		//测试使用从实现接口方法中获取的变量
		System.out.println("=======================测试Aware=========================");
		System.out.println("beanName is:" + beanName);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		List<String> beanDefinitionNameList = Arrays.asList(beanDefinitionNames);
		System.out.println("beanDefinitionNameList is :" + beanDefinitionNameList);
		System.out.println("========================================================");
	}

	//BeanNameAware中的接口，可以通过此接口方法获取当前容器的名称
	@Override
	public void setBeanName(String name) {
		//既然是set方法，就在上面定义一个成员变量beanName用于接收set的值
		this.beanName = name;
	}

	//ApplicationContextAware中的接口，可以通过此接口方法获取当前容器
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		//既然是set方法，就在上面定义一个成员变量applicationContext用于接收set的值
		this.applicationContext = applicationContext;
	}
}
