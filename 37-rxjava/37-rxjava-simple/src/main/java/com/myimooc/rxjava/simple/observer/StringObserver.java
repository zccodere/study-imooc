package com.myimooc.rxjava.simple.observer;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 字符串观察者
 *
 * @author zc 2020-03-23
 */
public class StringObserver implements Observer<String> {

    @Override
    public void onError(Throwable arg0) {
        System.out.println("onError()");
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete()");
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        System.out.println("onSubscribe()");
    }

    @Override
    public void onNext(String str) {
        System.out.println("onNext(): " + str);
    }
}
