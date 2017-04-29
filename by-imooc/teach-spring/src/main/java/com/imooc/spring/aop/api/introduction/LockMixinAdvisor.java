package com.imooc.spring.aop.api.introduction;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

import com.imooc.aop.api.introduction.LockMixin;
import com.imooc.aop.api.introduction.Lockable;

public class LockMixinAdvisor extends DefaultIntroductionAdvisor {

	private static final long serialVersionUID = -171332350782163120L;

	public LockMixinAdvisor() {
        super(new LockMixin(), Lockable.class);
    }
}
