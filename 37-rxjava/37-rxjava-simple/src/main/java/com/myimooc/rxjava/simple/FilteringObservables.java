package com.myimooc.rxjava.simple;

import com.myimooc.rxjava.simple.observer.IntegerObserver;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Predicate;

/**
 * 过滤操作符演示
 *
 * @author zc 2020-03-23
 */
public class FilteringObservables {

    public static void main(String[] args) {
        filterDebounce();
        filterDistinct();
        filterElementAt();
        filterFilter();
        filterIgnoreElements();
        filterLast();
        filterSample();
        filterSkip();
        filterTake();
    }

    /**
     * Take操作符:取对应数据项
     */
    private static void filterTake() {
        Observable.just(1, 2, 3, 4).takeLast(2).subscribe(new IntegerObserver());
    }

    /**
     * Skip操作符:跳过数据项
     */
    private static void filterSkip() {
        Observable.just(1, 2, 3, 4).skipLast(2).subscribe(new IntegerObserver());
    }

    /**
     * Sample操作符:取样
     */
    private static void filterSample() {
        int total = 10;

        // 使用JDK8的Lambda表达式创建对象
        ObservableSource<Integer> source = (observer) -> {
            try {
                for (int i = 0; i < total; i++) {
                    Thread.sleep(1000);
                    observer.onNext(i);
                }
                observer.onComplete();
            } catch (Exception e) {
                observer.onError(e);
            }
        };

        Observable.unsafeCreate(source).sample(4, TimeUnit.SECONDS).subscribe(new IntegerObserver());
    }

    /**
     * Last操作符:取数据项最后一个数据
     */
    private static void filterLast() {
        Observable.just(1, 2, 3, 2, 3).lastElement().subscribe(new IntegerObserver());
    }

    /**
     * IgnoreElements操作符:忽略掉指定元素，直接回调onCompleted或onError方法
     */
    private static void filterIgnoreElements() {
        // 使用JDK8的Lambda表达式创建对象
        ObservableSource<Integer> source = (observer) -> {
            observer.onNext(123);
            observer.onComplete();
//				throw new NullPointerException();
        };

        Observable.unsafeCreate(source).ignoreElements().subscribe(new IntegerObserver());
    }

    /**
     * Filter操作符:过滤
     */
    private static void filterFilter() {
        // 使用JDK8的Lambda表达式创建对象
        Predicate<Integer> predicate = (num) -> num > 1;

        Observable.just(1, 2, 3, 2, 3).distinct().filter(predicate).subscribe(new IntegerObserver());
    }

    /**
     * ElementAt操作符:取出指定位置的元素
     */
    private static void filterElementAt() {
        Observable.just(1, 2, 3, 2, 3).elementAt(3).subscribe(new IntegerObserver());
    }

    /**
     * Distinct操作符:去重操作符
     */
    private static void filterDistinct() {
        Observable.just(1, 2, 3, 2, 3).distinct().subscribe(new IntegerObserver());
    }

    /**
     * Debounce操作符:在操作后指定时间内无操作时响应
     */
    private static void filterDebounce() {
        int total = 10;

        // 使用JDK8的Lambda表达式创建对象
        ObservableSource<Integer> source = (observer) -> {
            try {
                for (int i = 0; i < total; i++) {
                    Thread.sleep(2000);
                    observer.onNext(i);
                }
                observer.onComplete();
            } catch (Exception e) {
                observer.onError(e);
            }
        };

        Observable.unsafeCreate(source).debounce(1, TimeUnit.SECONDS).subscribe(new IntegerObserver());
    }
}
