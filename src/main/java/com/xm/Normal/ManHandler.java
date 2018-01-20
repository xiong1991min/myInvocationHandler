package com.xm.Normal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by xm on 2018/1/20.
 */
public class ManHandler implements InvocationHandler {

	private Man man;

	public ManHandler(Man man) {
		this.man = man;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before......");
		method.invoke(man,null);
		System.out.println("after......");
		return null;
	}
}
