package com.xuan.service.impl;

import com.xuan.service.HelloService;

public class HelloServiceImpl implements HelloService {
	@Override
	public void sayHello(String name) {
		System.out.println("你好" + name);
	}
}
