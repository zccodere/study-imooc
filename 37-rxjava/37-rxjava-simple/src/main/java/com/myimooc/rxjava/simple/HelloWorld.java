package com.myimooc.rxjava.simple;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * HelloWorld类；入门案例HelloWorld
 *
 * @author zc 2020-03-21
 */
public class HelloWorld {

    public static void main(String[] args) {

        // 1.创建被观察者
        Observable<String> myObservable = Observable.unsafeCreate(observer -> {
            observer.onNext("hello World!");
            throw new NullPointerException("出错啦");
        });

        // 2.创建观察者
        Observer<String> mySubscriber = new Observer<String>() {

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
                System.out.println("onNext() " + str);
            }
        };

        // 3.订阅事件
        myObservable.subscribe(mySubscriber);
    }
}
