package com.xm.MyInvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xm on 2018/1/20.
 */
public class MyHandler implements MyInvocationHandler {
	private Man man;

	public MyHandler(Man man) {
		this.man = man;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
		System.out.println("before,you can do something...");
		Object invoke = method.invoke(man, null);
		System.out.println("after,you can do something...");
		return invoke;
	}
}
