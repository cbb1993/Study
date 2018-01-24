package com.andy.study.rxjava.rxjava1;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by 坎坎 on 2018/1/24.
 */

public class Test {

    /** rxjava 1
     * subscribeOn 执行线程
     * observeOn 回调线程
     * Schedulers   immediate() 当前线程运行
     *              newThread()  总是启用新线程，并在新线程执行操作。
     *              .io()   I/O 操作（读写文件、读写数据库、网络信息交互等）所使用的 Scheduler
     *              computation()  计算所使用的 Scheduler
     *              AndroidSchedulers.mainThread()：它指定的操作将在 Android 主线程运行
     * */
    public static void main(String[] args){
        String[] ss={"1","2","3","4",null};
        Observable.from(ss)
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return s!=null;
                    }
                })
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s+"--";
                    }
                })
                .subscribeOn(Schedulers.immediate())
                .observeOn(Schedulers.immediate())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }
}
