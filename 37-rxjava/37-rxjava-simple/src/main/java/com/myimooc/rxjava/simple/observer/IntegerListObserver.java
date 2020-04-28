package com.myimooc.rxjava.simple.observer;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 整型列表观察者
 *
 * @author zc 2020-03-23
 */
public class IntegerListObserver implements Observer<List<Integer>> {

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
    public void onNext(List<Integer> str) {
        System.out.println("onNext(): " + str);
    }
}
