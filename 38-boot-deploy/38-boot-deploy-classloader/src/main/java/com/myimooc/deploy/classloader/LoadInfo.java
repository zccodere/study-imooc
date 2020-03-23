package com.myimooc.deploy.classloader;

/**
 * 类加载信息；封装加载类的信息
 *
 * @author zc 2017-12-01
 */
public class LoadInfo {

    /**
     * 自定义的类加载器
     */
    private MyClassLoader myLoader;
    /**
     * 记录要加载类的时间戳，加载的时间
     */
    private long loadTime;

    private BaseManager manager;

    public LoadInfo(MyClassLoader myLoader, long loadTime) {
        super();
        this.myLoader = myLoader;
        this.loadTime = loadTime;
    }

    public MyClassLoader getMyLoader() {
        return myLoader;
    }

    public void setMyLoader(MyClassLoader myLoader) {
        this.myLoader = myLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getManager() {
        return manager;
    }

    public void setManager(BaseManager manager) {
        this.manager = manager;
    }
}
