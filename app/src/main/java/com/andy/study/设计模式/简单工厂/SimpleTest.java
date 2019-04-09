package com.andy.study.设计模式.简单工厂;

/**
 * Created by 斌斌.
 * Date: 2019/4/9
 * Time: 10:00
 * describe:
 */

/*
 * 思想：提供给客户端一个创建对象实例的功能，客户端无需知道其具体实现
 * 例子：厂里有两条生产线，分别可以生产 phone 和 pad
 *      客户端需要phone  ---> 工厂生产phone
 *      客户端需要pad  ---> 工厂生产pad
 *      这样客户端不需要关心产品是怎么生产不出来的，生产流程已经被定义好了
 *
 * 缺点 1.客户端要知道你有哪些能力，才能选择选择生产什么产品，增加了客户端的复杂度
 *      2. 不易于扩展
 * */

public class SimpleTest {
    public static void main(String[] args){
        SimpleFactory.createApi(1).doSomeThing();
        SimpleFactory.createApi(2).doSomeThing();
    }
}
