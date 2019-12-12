package com.imooc.proxy;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

import org.apache.commons.io.FileUtils;

public class Proxy {
	
	@SuppressWarnings("unchecked")
	public static Object newProxyInstance(Class infce,InvocationHandler h) throws Exception{
		String rt = "\r\n";
		String methodStr = "";
		for(Method m : infce.getMethods()){
			methodStr += "	@Override" + rt +
			"	public void " + m.getName() + "() {" + rt +
			"  try{" + rt +
			"  Method md = " + infce.getName() + ".class.getMethod(\"" 
										+ m.getName() + "\");" + rt +
			"  h.invoke(this,md);" +rt+ 
			"  }catch(Exception e){ e.printStackTrace();}" + rt +
			"	}" ;
		}
		
		String str =
		"package com.imooc.proxy;" + rt +
		"import java.lang.reflect.Method;" + rt +
		"import com.imooc.proxy.InvocationHandler;" +  rt+
		"public class $Proxy0 implements " + infce.getName() + " {" + rt +
		"	public $Proxy0(InvocationHandler h) {" + rt +
		"		this.h = h;" + rt +
		"	}" + rt +
		"  private InvocationHandler h;" + rt+ 
		methodStr + rt +
		"}" ;
		//产生代理类的java文件
		String filename = System.getProperty("user.dir") +"/bin/com/imooc/proxy/$Proxy0.java";
		File file = new File(filename);
		FileUtils.writeStringToFile(file, str);
		
		//编译
		//拿到编译器
		JavaCompiler complier = ToolProvider.getSystemJavaCompiler();
		//文件管理者
		StandardJavaFileManager fileMgr = 
				complier.getStandardFileManager(null, null, null);
		//获取文件
		Iterable units = fileMgr.getJavaFileObjects(filename);
		//编译任务
		CompilationTask t = complier.getTask(null, fileMgr, null, null, null, units);
		//进行编译
		t.call();
		fileMgr.close();
		
		//load 到内存
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		Class c = cl.loadClass("com.imooc.proxy.$Proxy0");
		
		Constructor ctr = c.getConstructor(InvocationHandler.class);
		return ctr.newInstance(h);
	}

	
	
	
}
