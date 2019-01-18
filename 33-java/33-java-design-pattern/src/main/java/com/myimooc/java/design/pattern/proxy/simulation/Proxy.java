package com.myimooc.java.design.pattern.proxy.simulation;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;

/**
 * @describe 模拟JDK动态代理-代理类
 * @author zc
 * @version 1.0 2017-08-28
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class Proxy {
	
	public static Object newProxyInstance( Class infce,InvocationHandler h)throws Exception{
		String rt = "\r\n";
		String methodStr = "";
		for(Method m : infce.getMethods()){
			methodStr += "	@Override" + rt +
			"	public void "+ m.getName() +"(){" + rt +
			" 	try{" + rt +
			"		Method md = " +infce.getName()+".class.getMethod(\""+m.getName()+"\");" + rt +
			"		h.invoke(this,md);" + rt +
			" 	}catch(Exception e){e.printStackTrace();}" + rt +
			"	}" + rt;
		}
		
		String str =
		"package com.myimooc.designpattern.proxy.simulation; " + rt +
		"import com.myimooc.designpattern.proxy.simulation.InvocationHandler;" + rt +
		"import java.lang.reflect.Method;" + rt +
		"public class $Proxy0 implements "+ infce.getName() +" { " + rt +
		"	public $Proxy0(InvocationHandler h) {" + rt +
		"		this.h = h;" + rt +
		"	}" + rt +
		"	private InvocationHandler h;" + rt +
		methodStr + rt +
		"}";
		
		// 产生代理类的java文件
		String filename = System.getProperty("user.dir") + "/target/classes/com/myimooc/designpattern/proxy/simulation/$Proxy0.java";
		File file = new File(filename);
		FileUtils.writeStringToFile(file, str,"UTF-8");
		
		// 编译-拿到编辑器
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		// 文件管理者
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		// 获取文件
		Iterable units = fileMgr.getJavaFileObjects(filename);
		// 编译任务
		CompilationTask task = compiler.getTask(null, fileMgr, null, null, null, units);
		// 进行编译
		task.call();
		fileMgr.close();
		
		// load到内存
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		Class c = cl.loadClass("com.myimooc.designpattern.c3proxy.simulationjdk.$Proxy0");
		
		Constructor ctr = c.getConstructor(InvocationHandler.class);
		return ctr.newInstance(h);
	}
}
