package com.andy.study.AOP;

import com.andy.study.AOP.annotation.BehaviorTrace;

/**
 * Created by 斌斌.
 * Date: 2019/4/9
 * Time: 11:22
 * describe: 面向切面编程
 */
public class AopTest {
    public static void main(String[] args){

        doSomeThing();
    }

    @BehaviorTrace("doSomeThing")
    private static void doSomeThing() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
