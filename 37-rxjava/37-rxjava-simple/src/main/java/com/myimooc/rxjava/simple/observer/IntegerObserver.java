package com.myimooc.rxjava.simple.observer;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 整型观察者
 *
 * @author zc 2020-03-23
 */
public class IntegerObserver implements Observer<Integer>, MaybeObserver<Integer>, CompletableObserver {

    @Override
    public void onError(Throwable arg0) {
        System.out.println("onError()" + arg0.getMessage());
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
    public void onSuccess(Integer integer) {
        System.out.println("MaybeObserver#onSubscribe()");
    }

    @Override
    public void onNext(Integer str) {
        System.out.println("onNext(): " + str);
    }
}
