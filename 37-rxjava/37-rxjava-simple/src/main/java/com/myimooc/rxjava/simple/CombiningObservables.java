package com.myimooc.rxjava.simple;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/**
 * @title 组合操作符
 * @describe 组合操作符演示
 * @author zc
 * @version 1.0 2017-10-17
 */
@SuppressWarnings("unused")
public class CombiningObservables {
	
	public static void main(String[] args) {
//		combiningZip();
//		combiningMerge();
//		combiningStartWith();
		combiningCombineLatest();
	}
	
	/**
	 * 用于将两个Observable最近传递的数据通过Func2函数的规则进行组合
	 */
	@SuppressWarnings("static-access")
	private static void combiningCombineLatest() {
		Observable<Integer> first = Observable.just(1,3,5);
		Observable<Integer> second = Observable.just(2,4,6);

		Observable.combineLatest(first,second,new Func2<Integer,Integer,Integer>(){
			@Override
			public Integer call(Integer num1, Integer num2) {
				System.out.println("num1 = "+num1 + " num2 = "+num2);
				return num1 + num2;
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
	 * 用于在源Observable传递的数据前增加数据
	 * 使用startWith(Iterable<T>)，还可以在源Observable传递的数据前增加Iterable
	 */
	private static void combiningStartWith() {
		Observable<Integer> first = Observable.just(1,3,5);
		Observable<Integer> second = Observable.just(2,4,6);
		
		first.startWith(second).subscribe(new Subscriber<Integer>() {
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
	 * 将两个Observable通知的事件序列合并成一个事件序列，就行是一个Observable通知的一样
	 * 可以简单的将它理解为两个Observable合并成了一个Observable
	 */
	private static void combiningMerge() {
		Observable<Integer> observable1 = Observable.just(1,3,5);
		Observable<Integer> observable2 = Observable.just(2,4,6);
		
		Observable.merge(observable1,observable2).subscribe(new Subscriber<Integer>() {
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
	 * 用来合并两个Observable传递的数据项，根据Func2函数生成一个新的值并传递出去
	 * 当其中一个Observable传递数据结束或者出现异常后，另一个Observable也将停止传递数据
	 */
	private static void combiningZip() {
		Observable<Integer> observable1 = Observable.just(10,20,30);
		Observable<Integer> observable2 = Observable.just(4,8,12,16);
		
		Observable.zip(observable1,observable2, new Func2<Integer,Integer,Integer>(){
			@Override
			public Integer call(Integer integer1, Integer integer2) {
				return integer1 + integer2;
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

	
	
}
