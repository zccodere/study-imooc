package com.myimooc.rxjava.simple;

import com.myimooc.rxjava.simple.observer.IntegerListObserver;
import com.myimooc.rxjava.simple.observer.IntegerObserver;
import com.myimooc.rxjava.simple.observer.StringObserver;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

/**
 * 转换操作符演示
 *
 * @author zc 2020-03-23
 */
public class TransformingObservables {

    public static void main(String[] args) {
        transformMap();
        transformFlatMap();
        transformGroupBy();
        transformBuffer();
        transformScan();
    }

    /**
     * Scan操作符:对数据进行累加
     */
    private static void transformScan() {
        // 使用JDK8的Lambda表达式进行求和
        BiFunction<Integer, Integer, Integer> biFunction = Integer::sum;

        Observable.range(1, 5).scan(biFunction).subscribe(new IntegerObserver());
    }

    /**
     * Buffer操作符:分批读取数据
     */
    private static void transformBuffer() {
        Observable.range(1, 5).buffer(2).subscribe(new IntegerListObserver());
    }

    /**
     * GroupBy操作符：对数据进行分组操作
     */
    private static void transformGroupBy() {
        // 使用JDK8的Lambda表达式进行对2取模
        Function<Integer, Integer> biFunction = (num) -> num % 2;

        Observable.just(1, 2, 3, 4, 5).groupBy(biFunction).subscribe(new Observer<GroupedObservable<Integer, Integer>>() {
            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable arg0) {
            }

            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(final GroupedObservable<Integer, Integer> groupedObservable) {
                groupedObservable.subscribe(new Observer<Integer>() {
                    @Override
                    public void onError(Throwable arg0) {
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

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
        // 使用JDK8的Lambda表达式进行将整体转换为字符串
        Function<Integer, Observable<? extends String>> biFunction = (num) -> Observable.just(String.valueOf(num));

        Observable.just(1, 2, 3, 4, 5).flatMap(biFunction).subscribe(new StringObserver());
    }

    /**
     * Map操作符：一个对象转换为另一个对象
     */
    private static void transformMap() {
        // 使用JDK8的Lambda表达式进行将整体转换为字符串
        Function<Integer, String> biFunction = String::valueOf;

        Observable.just(123).map(biFunction).subscribe(new StringObserver());
    }
}
