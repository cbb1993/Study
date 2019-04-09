package com.andy.study.设计模式.工厂方法;

/**
 * Created by 斌斌.
 * Date: 2019/4/9
 * Time: 10:35
 * describe:
 */

/*
 * 思想:将实例的生成交给子类
 * 例子：我想生产名片？？？生产100个人的名片不同的设计风格？？？我该咋办
 *       我们可以对问题进行分解
 *       相同点：都是名片
 *       不同点：名片内容不同
 *
 *       对象提取：总工厂：提供生产思路
 *                子工厂：提供具体生产
 *                总产品：共性提取---比如展示名片信息
 *                子产品：有不同标签
 *
 * 思路： 1.抽象出Factory提供生产方法  ---也可写成抽象类
 *       2. 抽象出Product 显示信息  ---也可写成抽象类
 *       3. 实现卡片
 *       4. 实现子工厂 CardFactory 生产名片并且在名片上印上不同信息
 * */
public class FactoryMethodTest {
    public static void main(String[] args) {
        Factory factory = new CardFactory();
        Product card1 = factory.createProduct("小黄");
        Product card2 = factory.createProduct("小荣");
        Product card3 = factory.createProduct("小华");
        card1.showMsg();
        card2.showMsg();
        card3.showMsg();
    }
}

interface Factory {
    Product createProduct(String msg);
}
interface Product {
    void showMsg();
}
class CardFactory implements Factory {
    @Override
    public Product createProduct(String msg) {
        return new Card(msg);
    }
}
class Card implements Product {
    private String msg;
    public Card(String msg) {
        this.msg = msg;
        System.out.println(String.format("生产了%s的名片", msg));
    }
    @Override
    public void showMsg() {
        System.out.println(String.format("展示了%s的名片", msg));
    }
}
