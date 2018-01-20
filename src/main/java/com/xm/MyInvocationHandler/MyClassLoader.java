package com.xm.MyInvocationHandler;

import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by xm on 2018/1/20.
 * 自定义加载器
 * 我们将自己在内存中生成动态代理类，那么我们如何加载呢？这时候，就可以利用自定义的类加载器做到！
 */
public class MyClassLoader extends ClassLoader{
	//生成的代理类加载路径
	private File dir;
	private String proxyClassPackages;

	public MyClassLoader(String path, String proxyClassPackages) {
		this.dir = new File(path);
		this.proxyClassPackages = proxyClassPackages;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		if(dir != null){
			File classFile = new File(dir,name+".class");
			if(classFile.exists()){
				try {
					//生成class的二进制字节流
					byte[] classBytes = FileCopyUtils.copyToByteArray(classFile);
					return defineClass(proxyClassPackages+"."+name,classBytes,0,classBytes.length);

				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}
		//如果上面没有加载到，走默认的加载方式
		return super.findClass(name);
	}

	public File getDir() {
		return dir;
	}

	public void setDir(File dir) {
		this.dir = dir;
	}

	public String getProxyClassPackages() {
		return proxyClassPackages;
	}

	public void setProxyClassPackages(String proxyClassPackages) {
		this.proxyClassPackages = proxyClassPackages;
	}
}
