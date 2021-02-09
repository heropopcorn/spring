package com.xuan;

import com.xuan.controller.HelloController;
import com.xuan.entity.User;
import com.xuan.entity.factory.UserFactoryBean;
import com.xuan.service.HelloService;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;


@Configuration
@ComponentScan("com.xuan")
public class Entrance {
	public static void main0(String[] args) {
		System.out.println("造");
		System.out.println("态");
		System.out.println((int)'无');
		System.out.println((int)'造');
		System.out.println((int)'态');
		System.out.println((char)36896);
	}
	/**
	 * 使用xml的方式
	 *
	 * @param args
	 */
	public static void main1(String[] args) {
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

		//得到无参构造函数创建的对象:

		User user1a = (User) applicationContext.getBean("user1");
		User user1b = (User) applicationContext.getBean("user1");

		//得到静态工厂创建的对象:

		User user2a = (User) applicationContext.getBean("user2");
		User user2c = (User) applicationContext.getBean("user2");

		//得到实例工厂创建的对象:

		User user3a = (User) applicationContext.getBean("user3");
		User user3b = (User) applicationContext.getBean("user3");

		//UserFactoryBean
		/**
		 * 在配置文件中虽然配置的类为UserFactoryBean，但是此处根据名称获取的是User类型，
		 * 这就是因为UserFactoryBean实现了FactoryBean接口的效果
		 * 此时如果想获取UserFactoryBean本身，只要加入FactoryBean中定义的前缀“&”即可
		 */
		User user4a = (User) applicationContext.getBean("user4");
		UserFactoryBean user4b = (UserFactoryBean) applicationContext.getBean("&user4");

		System.out.println("无参构造函数创建的对象:" + user1a);
		System.out.println("无参构造函数创建的对象:" + user1b);
		System.out.println("静态工厂创建的对象：" + user2a);
		System.out.println("静态工厂创建的对象：" + user2c);
		System.out.println("实例工厂创建的对象：" + user3a);
		System.out.println("实例工厂创建的对象：" + user3b);
		System.out.println("实例工厂创建的对象：" + user4a);
		System.out.println("实例工厂创建的对象：" + user4b);

	}

	/**
	 * 使用注解的方式
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("==========================================");
		//此处需要传入配置类
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Entrance.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
		HelloController helloController = (HelloController) applicationContext.getBean("helloController");
		helloController.handleRequest();
		System.out.println("==========================================");
		System.out.println(applicationContext.getBean("userTest"));
	}
}
