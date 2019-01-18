package com.myimooc.rxjava.simple;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.GroupedObservable;

/**
 * @title 转换操作符
 * @describe 转换操作符演示
 * @author zc
 * @version 1.0 2017-10-16
 */
@SuppressWarnings("unused")
public class TransformingObservables {
	
	public static void main(String[] args) {
//		transformMap();
//		transformFlatMap();
//		transformGroupBy();
//		transformBuffer();
		transformScan();
	}

	/**
	 * Scan操作符:对数据进行累加
	 */
	private static void transformScan() {
		Observable.range(1,5).scan(new Func2<Integer, Integer, Integer>() {
			
			@Override
			public Integer call(Integer sum, Integer num) {
				return sum + num;
			}
			
		}).subscribe(new Observer<Integer>() {
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
	 * Buffer操作符:分批读取数据
	 */
	private static void transformBuffer() {
		Observable.range(1,5).buffer(2).subscribe(new Observer<List<Integer>>() {
			@Override
			public void onCompleted() {
				System.out.println("onCompleted()");
			}
			@Override
			public void onError(Throwable arg0) {
				System.out.println("onError()");
			}
			@Override
			public void onNext(List<Integer> str) {
				System.out.println("onNext(): " + str);
			}
		});
	}

	/**
	 * GroupBy操作符：对数据进行分组操作
	 */
	private static void transformGroupBy() {
		Observable.just(1,2,3,4,5).groupBy(new Func1<Integer,Integer>(){

			@Override
			public Integer call(Integer data) {
				return data % 2;
			}
			
		}).subscribe(new Observer<GroupedObservable<Integer,Integer>>() {
			@Override
			public void onCompleted() {
			}
			@Override
			public void onError(Throwable arg0) {
			}
			@Override
			public void onNext(final GroupedObservable<Integer, Integer> groupedObservable) {
				groupedObservable.subscribe(new Subscriber<Integer>() {

					@Override
					public void onCompleted() {
					}
					@Override
					public void onError(Throwable arg0) {
					}
					@Override
					public void onNext(Integer data) {
						System.out.println("group:" + groupedObservable.getKey() + " data:" + data);
					}
				});
			}
		});
	}

	/**
	 * FlatMap操作符：一个对象转换为多个对象
	 */
	private static void transformFlatMap() {
		
		Observable.just(1,2,3,4,5).flatMap(new Func1<Integer,Observable<? extends String>>(){

			@Override
			public Observable<? extends String> call(Integer num) {
				return Observable.just(String.valueOf(num));
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

	/**
	 * Map操作符：一个对象转换为另一个对象
	 */
	private static void transformMap() {
		
		Observable.just(123).map(new Func1<Integer,String>(){

			@Override
			public String call(Integer num) {
				return String.valueOf(num);
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
