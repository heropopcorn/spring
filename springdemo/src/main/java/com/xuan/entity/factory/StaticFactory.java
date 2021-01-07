package com.xuan.entity.factory;

import com.xuan.entity.User;

public class StaticFactory {

	public static User getUser(){
		return new User();
	}
}
