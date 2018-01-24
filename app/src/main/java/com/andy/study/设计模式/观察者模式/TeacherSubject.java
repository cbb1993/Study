package com.andy.study.设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 坎坎 on 2018/1/23.
 */

public class TeacherSubject implements Subject {
    //用来存放和记录观察者
    private List<Observer> observers=new ArrayList<Observer>();
    //记录状态的字符串
    private String info;

    @Override
    public void addObserver(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void deleteObserver(Observer obj) {
        int i = observers.indexOf(obj);
        if(i>=0){
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i=0;i<observers.size();i++){
            Observer o=(Observer)observers.get(i);
            o.update(info);
        }
    }
    //布置作业的方法,在方法最后,需要调用notifyObserver()方法,通知所有观察者更新状态
    public void setHomework(String info){
        this.info=info;
        System.out.println("今天的作业是"+info);
        this.notifyObserver();
    }

}
