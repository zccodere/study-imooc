package com.myimooc.rxjava.simple;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.functions.Func0;
import rx.Subscriber;

/**
 * @title 创建操作符
 * @describe 创建操作符演示
 * @author zc
 * @version 1.0 2017-10-16
 */
@SuppressWarnings("unused")
public class CreatingObservables {
	
	public static void main(String[] args) {
//		create();
//		just();
//		from();
//		defer();
		repeat();
	}
	
	/**
	 * repeat操作符
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void repeat() {
		Observable observable= Observable.range(1,5).repeat(2);
		observable.subscribe(new Subscriber<Integer>() {
			@Override
			public void onCompleted() {
				System.out.println("onCompleted()");
			}
			@Override
			public void onError(Throwable arg0) {
				System.out.println("onError()");
			}
			@Override
			public void onNext(Integer str) {
				System.out.println("onNext(): " + str);
			}
		});
	}
	
	/**
	 * range操作符
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void range() {
		Observable observable= Observable.range(1,5);
		observable.subscribe(new Subscriber<Integer>() {
			@Override
			public void onCompleted() {
				System.out.println("onCompleted()");
			}
			@Override
			public void onError(Throwable arg0) {
				System.out.println("onError()");
			}
			@Override
			public void onNext(Integer str) {
				System.out.println("onNext(): " + str);
			}
		});
	}

	private static String deferStr = "default";
	/**
	 * defer操作符
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void defer() {
		Observable observable= Observable.defer(new Func0<Observable<String>>() {
			@Override
			public Observable<String> call() {
				return Observable.just(deferStr);
			}
		});
		deferStr = "RxJava";
		observable.subscribe(new Subscriber<String>() {
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
				System.out.println("onNext(): " + str);
			}
		});
	}

	/**
	 * from操作符
	 */
	private static void from() {
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		Observable.from(nums).subscribe(new Subscriber<Integer>() {
			@Override
			public void onCompleted() {
				System.out.println("onCompleted()");
			}
			@Override
			public void onError(Throwable arg0) {
				System.out.println("onError()");
			}
			@Override
			public void onNext(Integer str) {
				System.out.println("onNext(): " + str);
			}
		});
	}

	/**
	 * just操作符
	 */
	private static void just() {
		Observable.just("RxJava").subscribe(new Subscriber<String>() {
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
				System.out.println("onNext(): " + str);
			}
		});
	}

	/**
	 * Create操作符
	 */
	private static void create() {
		Observable.unsafeCreate(new OnSubscribe<String>(){
			@Override
			public void call(Subscriber<? super String> subscriber) {
				subscriber.onNext("RxJava");
			}
		}).subscribe(new Subscriber<String>() {
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
				System.out.println("onNext(): " + str);
			}
		});
	}
}
