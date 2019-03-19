package com.andy.study.设计模式.模板方法模式;

public class Template {
    public static void main(String[] args) {
        DoFlow a = new A();
        DoFlow b = new B();
        a.doThis();
        b.doThis();
    }

    /**
     * Template Method(模板方法)模式
     * 思想：在父类中定义处理流程，在子类中实现具体处理
     *
     * 举例：把大象关进冰箱
     *       规定：打开冰箱 --> 把大象放进冰箱  --> 关闭冰箱
     *       这时候 A、B都来关大象啦
     *       A: 哭着打开冰箱 --> 哭着把大象放进冰箱  --> 哭着关闭冰箱
     *       B: 旋转跳跃着打开冰箱 --> 旋转跳跃着把大象放进冰箱  --> 旋转跳跃着关闭冰箱
     *
     *       我们可以看出 我们不关心他们是怎么实现打开、放入、和关闭操作的,我们只确定是按这个流程来执行的
     * */

    /**
     *  以上例子可以看出,我们制定了执行流程，每步里面的具体操作都有子类自己来实现
     *
    *   优点:可以使处理逻辑通用化，父类和子类具有一致性且相互协作
     *  缺点：1.限定的太死，限制了子类的灵活性
     *        2.父类只是定义了流程，有可能导致子类实现过于臃肿，多个子类之间实现的代码也有可能重复
    * */

    /**
    *  定义流程
    * */
    static abstract class DoFlow{
        abstract void open(); // 打开
        abstract void put(); //放入
        abstract void close(); // 关闭
        public final void doThis(){
            // 定义流程 注意final 让子类不能修改流程，只能按照流程走
            open();
            put();
            close();
        }
    }
    /**
     *  A的具体实现
     * */
    static class A extends DoFlow{
        @Override
        void open() {
            System.out.print("A哭着打开\n");
        }
        @Override
        void put() {
            System.out.print("A哭着放入\n");
        }
        @Override
        void close() {
            System.out.print("A哭着关闭\n");
        }
    }
    /**
     *  B的具体实现
     * */
    static class B extends DoFlow{
        @Override
        void open() {
            System.out.print("B旋转跳跃着打开\n");
        }
        @Override
        void put() {
            System.out.print("B旋转跳跃着放入\n");
        }
        @Override
        void close() {
            System.out.print("B旋转跳跃着关闭\n");
        }
    }
}

