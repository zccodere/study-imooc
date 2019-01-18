package com.myimooc.rxjava.simple;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

/**
 * @title HelloWorld类
 * @describe 3-1 入门案例HelloWorld
 * @author zc
 * @version 1.0 2017-10-16
 */
public class HelloWorld 
{
    @SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public static void main( String[] args )
    {
        
    	// 1.创建被观察者
    	Observable myObservable = Observable.unsafeCreate(new OnSubscribe<String>(){
			@Override
			public void call(Subscriber<? super String> subscriber) {
				subscriber.onNext("hello World!");
				throw new NullPointerException("出错啦");
			}
    	});
    	
    	// 2.创建观察者
    	Subscriber mySubscriber = new Subscriber<String>(){
			@Override
			public void onCompleted() {
				System.out.println("onCompleted()");
			}
			@Override
			public void onError(Throwable arg0) {
				System.out.println("onError()");
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
