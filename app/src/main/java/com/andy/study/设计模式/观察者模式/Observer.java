package com.andy.study.设计模式.观察者模式;

/**
 * Created by 坎坎 on 2018/1/23.
 */

public interface Observer {
    //当主题状态改变时,会将一个String类型字符传入该方法的参数,每个观察者都需要实现该方法
    public void update(String info);
}
