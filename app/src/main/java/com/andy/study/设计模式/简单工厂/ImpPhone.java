package com.andy.study.设计模式.简单工厂;

/**
 * Created by 斌斌.
 * Date: 2019/4/9
 * Time: 9:58
 * describe: Phone
 */
public class ImpPhone implements SimpleApi {
    @Override
    public void doSomeThing() {
        System.out.println("phone亮了");
    }
}
