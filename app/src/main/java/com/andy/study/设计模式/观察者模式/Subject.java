package com.andy.study.设计模式.观察者模式;


/**
 * Created by 坎坎 on 2018/1/23.
 */
public interface Subject {
    //添加观察者
    void addObserver(Observer obj);
    //移除观察者
    void deleteObserver(Observer obj);
    //当主题方法改变时,这个方法被调用,通知所有的观察者
    void notifyObserver();
}
