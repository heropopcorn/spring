package com.xuan.demo;

import org.springframework.core.io.FileSystemResource;

import java.io.File;

public class ResourceDemo {
	public static void main(String[] args) {
		FileSystemResource fileSystemResource = new FileSystemResource("D:\\project\\myproject\\spring-framework-5.2.0.RELEASE\\springdemo\\src\\main\\java\\com\\xuan\\demo\\resource\\test.txt");
		File file = fileSystemResource.getFile();
		System.out.println(file.length());
	}
}
