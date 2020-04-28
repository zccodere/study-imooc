package com.myimooc.rxjava.simple;

import com.myimooc.rxjava.simple.observer.IntegerObserver;
import com.myimooc.rxjava.simple.observer.StringObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

/**
 * 创建操作符演示
 *
 * @author zc 2020-03-21
 */
public class CreatingObservables {

    public static void main(String[] args) {
        create();
        range();
        just();
        from();
        defer();
        repeat();
    }

    /**
     * repeat操作符
     */
    private static void repeat() {
        Observable<Integer> observable = Observable.range(1, 5).repeat(2);
        observable.subscribe(new IntegerObserver());
    }

    /**
     * range操作符
     */
    private static void range() {
        Observable<Integer> observable = Observable.range(1, 5);
        observable.subscribe(new IntegerObserver());
    }

    private static String deferStr = "default";

    /**
     * defer操作符
     */
    private static void defer() {

        // 使用JDK8的Lambda表达式创建对象
        Callable<ObservableSource<String>> callable = () -> Observable.just(deferStr);

        Observable<String> observable = Observable.defer(callable);
        deferStr = "RxJava";
        observable.subscribe(new StringObserver());
    }

    /**
     * from操作符
     */
    private static void from() {
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        Observable.fromIterable(numList).subscribe(new IntegerObserver());
    }

    /**
     * just操作符
     */
    private static void just() {
        Observable.just("RxJava").subscribe(new StringObserver());
    }

    /**
     * Create操作符
     */
    private static void create() {
        // 使用JDK8的Lambda表达式创建对象
        ObservableSource<String> source = (observer) -> {
            observer.onNext("hello World!");
            throw new NullPointerException("出错啦");
        };

        Observable.unsafeCreate(source).subscribe(new StringObserver());
    }
}
