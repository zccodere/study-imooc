package com.imooc.spring.aop.api.introduction;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import com.imooc.aop.api.introduction.Lockable;

public class LockMixin extends DelegatingIntroductionInterceptor implements Lockable {

	private static final long serialVersionUID = 6943163819932660450L;
	
	private boolean locked;

    public void lock() {
        this.locked = true;
    }

    public void unlock() {
        this.locked = false;
    }

    public boolean locked() {
        return this.locked;
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (locked() && invocation.getMethod().getName().indexOf("set") == 0) {
            throw new RuntimeException();
        }
        return super.invoke(invocation);
    }

}
