package com.myimooc.java.design.pattern.proxy.simulation;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * 模拟JDK动态代理-代理类
 *
 * @author zc 2017-08-28
 */
public class Proxy {

    public static Object newProxyInstance(Class interfaceClass, InvocationHandler handler) throws Exception {
        String rt = "\r\n";
        StringBuilder methodStr = new StringBuilder();
        for (Method m : interfaceClass.getMethods()) {
            methodStr.append("	@Override").append(rt).append("	public void ").append(m.getName()).append("(){").append(rt).append(" 	try{").append(rt).append("		Method md = ").append(interfaceClass.getName()).append(".class.getMethod(\"").append(m.getName()).append("\");").append(rt).append("		h.invoke(this,md);").append(rt).append(" 	}catch(Exception e){e.printStackTrace();}").append(rt).append("	}").append(rt);
        }

        String str =
                "package com.myimooc.java.design.pattern.proxy.simulation; " + rt +
                        "import com.myimooc.java.design.pattern.proxy.simulation.InvocationHandler;" + rt +
                        "import java.lang.reflect.Method;" + rt +
                        "public class $Proxy0 implements " + interfaceClass.getName() + " { " + rt +
                        "	public $Proxy0(InvocationHandler h) {" + rt +
                        "		this.h = h;" + rt +
                        "	}" + rt +
                        "	private InvocationHandler h;" + rt +
                        methodStr + rt +
                        "}";

        // 产生代理类的java文件
        String filename = System.getProperty("user.dir") + "/33-java/33-java-design-pattern/target/classes/com/myimooc/java/design/pattern/proxy/simulation/$Proxy0.java";
        File file = new File(filename);
        FileUtils.writeStringToFile(file, str, "UTF-8");

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
        Class c = cl.loadClass("com.myimooc.java.design.pattern.proxy.simulation.$Proxy0");

        @SuppressWarnings("unchecked")
        Constructor ctr = c.getConstructor(InvocationHandler.class);
        return ctr.newInstance(handler);
    }
}
