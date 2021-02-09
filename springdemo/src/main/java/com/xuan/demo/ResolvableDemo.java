package com.xuan.demo;

import org.springframework.core.ResolvableType;

import java.util.HashMap;
import java.util.List;

public class ResolvableDemo {
	private HashMap<String, List<Integer>> customizedMap;

	public static void main(String[] args) throws NoSuchFieldException {
		ResolvableType resolvableType = ResolvableType.forField(ResolvableDemo.class.getDeclaredField("customizedMap"));
		System.out.println(resolvableType.getGeneric(0).resolve());
		System.out.println(resolvableType.getGeneric(1).resolve());
		System.out.println(resolvableType.getGeneric(1,0).resolve());
		System.out.println(resolvableType.getSuperType());
	}
}
