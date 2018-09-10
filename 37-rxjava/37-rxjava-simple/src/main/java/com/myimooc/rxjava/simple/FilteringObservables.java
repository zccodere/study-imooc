package com.myimooc.rxjava.simple;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * @title 过滤操作符
 * @describe 过滤操作符演示
 * @author zc
 * @version 1.0 2017-10-17
 */
@SuppressWarnings("unused")
public class FilteringObservables {
	
	public static void main(String[] args) {
//		filterDebounce();
//		filterDistinct();
//		filterElementAt();
//		filterFilter();
//		filterIgnoreElements();
//		filterLast();
//		filterSample();
//		filterSkip();
		filterTake();
	}

	/**
	 * Take操作符:取对应数据项
	 */
	private static void filterTake() {
		Observable.just(1,2,3,4).takeLast(2).subscribe(new Subscriber<Integer>() {
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
	 * Skip操作符:跳过数据项
	 */
	private static void filterSkip() {
		Observable.just(1,2,3,4).skipLast(2).subscribe(new Subscriber<Integer>() {
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
	 * Sample操作符:取样
	 */
	private static void filterSample() {
		int total =10;
		Observable.unsafeCreate(new OnSubscribe<Integer>(){
			@Override
			public void call(Subscriber<? super Integer> arg) {
				try{
					for (int i=0;i<total;i++){
						Thread.sleep(1000);
						arg.onNext(i);
					}
					arg.onCompleted();
				}catch (Exception e) {
					arg.onError(e);
				}
			}
		}).sample(4, TimeUnit.SECONDS).subscribe(new Subscriber<Integer>() {
			@Override
			public void onCompleted() {
				System.out.println("onCompleted()");
			}
			@Override
			public void onError(Throwable arg0) {
				System.out.println("onError()" + arg0.getMessage());
			}
			@Override
			public void onNext(Integer str) {
				System.out.println("onNext(): " + str);
			}
		});
	}

	/**
	 * Last操作符:取数据项最后一个数据
	 */
	private static void filterLast() {
		Observable.just(1,2,3,2,3).last().subscribe(new Subscriber<Integer>() {
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
	 * IgnoreElements操作符:忽略掉指定元素，直接回调onCompleted或onError方法
	 */
	private static void filterIgnoreElements() {
		Observable.unsafeCreate(new OnSubscribe<Integer>() {
			@Override
			public void call(Subscriber<? super Integer> arg) {
				arg.onNext(123);
				arg.onCompleted();
//				throw new NullPointerException();
			}
		}).ignoreElements().subscribe(new Subscriber<Integer>() {
			@Override
			public void onCompleted() {
				System.out.println("onCompleted()");
			}
			@Override
			public void onError(Throwable arg0) {
				System.out.println("onError()" + arg0.getMessage());
			}
			@Override
			public void onNext(Integer str) {
				System.out.println("onNext(): " + str);
			}
		});
	}

	/**
	 * Filter操作符:过滤
	 */
	private static void filterFilter() {
		Observable.just(1,2,3,2,3).distinct().filter(new Func1<Integer, Boolean>() {
			@Override
			public Boolean call(Integer arg) {
				return arg > 1;
			}
		}).subscribe(new Subscriber<Integer>() {
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
	 * ElementAt操作符:取出指定位置的元素
	 */
	private static void filterElementAt() {
		Observable.just(1,2,3,2,3).elementAt(3).subscribe(new Subscriber<Integer>() {
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
	 * Distinct操作符:去重操作符
	 */
	private static void filterDistinct() {
		Observable.just(1,2,3,2,3).distinct().subscribe(new Subscriber<Integer>() {
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
	 * Debounce操作符:在操作后指定时间内无操作时响应
	 */
	private static void filterDebounce() {
		int total = 10;
		Observable.unsafeCreate(new OnSubscribe<Integer>(){
			@Override
			public void call(Subscriber<? super Integer> arg) {
				try{
					for (int i=0;i<total;i++){
						Thread.sleep(2000);
						arg.onNext(i);
					}
					arg.onCompleted();
				}catch (Exception e) {
					arg.onError(e);
				}
			}
		}).debounce(1,TimeUnit.SECONDS).subscribe(new Subscriber<Integer>() {
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
	
	

}
