package com.young.libdemo.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.junit.Test;



/**
 * @author: yzx
 * @date: 2018/8/27
 * @description:
 */
public class RxDemo {

    @Test
    public void test01() {
        Observable.create(
                (ObservableOnSubscribe<Integer>) observableEmitter -> {
                    System.out.println("emit"+1);
                    observableEmitter.onNext(1);
                    System.out.println("emit" + 2);
                    observableEmitter.onNext(2);
                    System.out.println("emit" + 2);
                    observableEmitter.onNext(3);
                    System.out.println("emit" + 3);
                    observableEmitter.onNext(4);
                    System.out.println("emit" + 4);
                    observableEmitter.onComplete();
                }
        ).subscribe(new Observer<Integer>() {  //订阅

            private Disposable disposable;
            private int i = 1;


            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("disposable");
                disposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext" + integer);
                i++;
                if (i == 2) {
                    disposable.dispose();
                    System.out.println("isDisposed"+disposable.isDisposed());
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error");
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        });
    }
}
