package com.xm.Normal;

import java.lang.reflect.Proxy;

/**
 * Created by xm on 2018/1/20.
 * 动态代理的过程是这样的：
 * 第一：Proxy通过传递给它的参数（interfaces/invocationHandler）生成代理类$Proxy0；
 * 第二：Proxy通过传递给它的参数（ClassLoader）来加载生成的代理类$Proxy0的字节码文件；
 */
public class Main {
	public static void main(String[] args) {
		Man man = new Xiongmin();
		ManHandler manHandler = new ManHandler(new Xiongmin());
		Man proxyMan = (Man) Proxy.newProxyInstance(man.getClass().getClassLoader(), man.getClass().getInterfaces(), manHandler);
		System.out.println(proxyMan.getClass().getName());
		proxyMan.say();
	}

}
