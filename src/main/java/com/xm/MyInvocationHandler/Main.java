package com.xm.MyInvocationHandler;

/**
 * Created by xm on 2018/1/20.
 */
public class Main {

	public static void main(String[] args) throws Throwable {
		Man man = new Xiongmin();
		MyHandler myHandler = new MyHandler(man);
		Man proxyMan = (Man) MyProxy.newProxyInstance(new MyClassLoader("/Users/xm/project/myInvocationHandler/src/main/java/com/xm/MyInvocationHandler","com.xm.MyInvocationHandler"), Man.class, myHandler);
		System.out.println(proxyMan.getClass().getName());
		proxyMan.say();
	}

}
