package com.myimooc.rxjava.simple;

import com.myimooc.rxjava.simple.observer.IntegerObserver;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;

/**
 * 组合操作符；组合操作符演示
 *
 * @author zc 2020-03-23
 */
public class CombiningObservables {

    public static void main(String[] args) {
        combiningZip();
        combiningMerge();
        combiningStartWith();
        combiningCombineLatest();
    }

    /**
     * 用于将两个Observable最近传递的数据通过BiFunction函数的规则进行组合
     */
    private static void combiningCombineLatest() {
        ObservableSource<Integer> first = Observable.just(1, 3, 5);
        ObservableSource<Integer> second = Observable.just(2, 4, 6);

        // 对两个数进行求和
        BiFunction<Integer, Integer, Integer> biFunction = (num1, num2) -> {
            System.out.println("num1 = " + num1 + " num2 = " + num2);
            return num1 + num2;
        };

        Observable.combineLatest(first, second, biFunction).subscribe(new IntegerObserver());
    }

    /**
     * 用于在源Observable传递的数据前增加数据 使用startWith(Iterable<T>)，还可以在源Observable传递的数据前增加Iterable
     */
    private static void combiningStartWith() {
        Observable<Integer> first = Observable.just(1, 3, 5);
        Observable<Integer> second = Observable.just(2, 4, 6);

        first.startWith(second).subscribe(new IntegerObserver());
    }

    /**
     * 将两个Observable通知的事件序列合并成一个事件序列，就行是一个Observable通知的一样 可以简单的将它理解为两个Observable合并成了一个Observable
     */
    private static void combiningMerge() {
        Observable<Integer> observable1 = Observable.just(1, 3, 5);
        Observable<Integer> observable2 = Observable.just(2, 4, 6);

        Observable.merge(observable1, observable2).subscribe(new IntegerObserver());
    }

    /**
     * 用来合并两个Observable传递的数据项，根据BiFunction函数生成一个新的值并传递出去 当其中一个Observable传递数据结束或者出现异常后，另一个Observable也将停止传递数据
     */
    private static void combiningZip() {
        Observable<Integer> observable1 = Observable.just(10, 20, 30);
        Observable<Integer> observable2 = Observable.just(4, 8, 12, 16);

        // 对两个数进行求和
        BiFunction<Integer, Integer, Integer> biFunction = (num1, num2) -> {
            System.out.println("num1 = " + num1 + " num2 = " + num2);
            return num1 + num2;
        };

        Observable.zip(observable1, observable2, biFunction).subscribe(new IntegerObserver());
    }
}
