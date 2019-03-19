package com.andy.study.设计模式.代理模式;

public class ProxyC {
    public static void main(String[] args) {

        IEmit e = new EmitProxy("张三");
        System.out.print("我的名字=="+e.getName()+"\n");
        e.setName("李四");
        System.out.print("我的名字=="+e.getName()+"\n");
        e.emit();
    }

    /**
     * proxy模式
     * 思想：有些事不需要本人去完成的，就可以让别人代理完成，但代理人遇到自己无法解决的问题时会寻求本人帮助。
     *       被代理者不知道代理的存在，不知道自己是通过代理被调用的还是直接被调用的
     *
     *   为什么要用代理呢?
     *   举个例子: (问题一) 张三仅仅想知道村口老王家的女儿叫什么
     *              1.询问老王
     *              2.到老王家他家女儿化妆2个小时出来告诉你名字
     *              站在这个问题的立场上,张三仅仅是想知道名字,那么最优解就是询问老王,在这过程中,女儿毫不知情
     *
     *            (问题二) 张三想和老王女儿翠花结婚
     *              1. 老王和张三结婚
     *              2. 翠花和张三结婚
     *              我们都是新世纪小青年,当然会选择2啦,这时候老王自己就不能完成这个事情了,不管多麻烦,结婚这件事都要翠花自己来
     *
     *              程序设计和现实还是有所不同的,本着低耦合的原则,
     *              被代理者只需要做,不需要知道谁在让他做.
     *              代理者强制执行代理行为,也不需要经过被代理者同意
     *
     *              A  ---询问C名字-->  B直接回答了  -------> C不知情
     *              A  ---让C上天-->  B让C上天  ---> C知道有人让我上天了,并不关心是谁让他上天,然后执行了上天操作
     *              在这过程中 A都得到了想要的结果, 也不关心过程
     *
     *              这样在在设计接口时只要抽象出C所有的功能,B作为代理须有C的全部功能,只是最后看需要的时候B能不能实现的问题
     */

    interface IEmit{
        String getName(); // 获得名字
        void setName(String name); //设置名字
        void emit(); //发射
    }
    static class Emit implements IEmit{
        private String name;
        public Emit(String name){
            this.name =name;
            // 实例化的时候 一些列复杂操作
            System.out.print(name+"--做了一些列准备工作");
        }
        @Override
        public String getName() {
            return name;
        }
        @Override
        public void setName(String name) {
            this.name =name;
        }
        @Override
        public void emit() {
            System.out.print(name+"--我上天啦");
        }
    }
    static class EmitProxy implements IEmit{
        private String name;
        private Emit real;
        public EmitProxy(String name){
            this.name =name;
        }
        @Override
        public String getName() {
            return name;
        }
        @Override
        public void setName(String name) {
            if(real!=null){
                real.setName(name);
            }
            this.name =name;
        }
        @Override
        public void emit() {
            realize(); // 此处代理做不了  需要实例化
        }
        public void realize(){
            if(real==null){
                real= new Emit(name);
            }
        }
    }
}

/**
 *   对于以上的例子，大家也许会有疑问，为什么不直接操作Emit对象，非要搞一个代理，步骤还复杂了...
 *
 *   解释 在上面的例子中Emit对象实例化时需要进行很多复杂耗时操作
 *        如果多个类似Emit的对象在程序开始时就实例化,那么可能导致内存飙升等问题。
 *        而且我们直接进行调用的时候，那就意味着你必须等待这些复杂耗时操作完成，哪怕你只是需要来执行一些简单的操作。
 *        这样的程序显然不是我们希望看到的
 *        所以，我们插入了代理EmitProxy，虽然一开始我们要new一个EmitProxy对象，但是消耗比Emit对象小很多，
 *        这样，我们执行一些简单操作的时候，就可以通过EmitProxy来完成，而不需要Emit对象
 *        当EmitProxy完成不了的任务时，我们再去实例化Emit对象执行，这样就延迟了Emit实例化的时间，更符合程序设计
 *
 *        上面的例子，在setName()和getName()的时候 都没有实例化Emit对象，也达到了目的
 *        直到调用emit()方法时才进行了实例化
 * */
