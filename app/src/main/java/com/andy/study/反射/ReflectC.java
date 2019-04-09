package com.andy.study.反射;



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ReflectC {
    public static void main(String[] args){
        newInstance();
    }

   // 获取类
    private static void reflectClz(){
        try {
            // classLoader装载类，并进行类的初始化
            Class c1 = Class.forName("com.andy.study.反射.TestClass");
            // classLoader装载入内存，不对类进行类的初始化操作
            Class c2 = TestClass.class;
            //返回类对象运行时真正所指的对象，所属类型的class对象
            Class c3 = new TestClass().getClass();
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 创建对象
    private static void newInstance(){
        Object o;
        try {
            // 无参
            o = Class.forName("com.andy.study.反射.TestClass").newInstance();
            System.out.println(o);
            // 有参
            Constructor constructor = Class.forName("com.andy.study.反射.TestClass").getDeclaredConstructor(int.class);
            constructor.setAccessible(true);
            o=constructor.newInstance(12);
            System.out.println(o);
            System.out.println(((TestClass)o).getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 反射属性和方法
    private static void getField(){
        TestClass testClass =new TestClass();
        try {
            Class clz= Class.forName("com.andy.study.反射.TestClass");
            Field field = clz.getDeclaredField("age");
            field.setAccessible(true);
            field.set(testClass,20);
            System.out.println(testClass.getAge());
            Method m = clz.getDeclaredMethod("setAge",int.class);
            m.setAccessible(true);
            m.invoke(testClass,100);
            System.out.println(testClass.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //静态
}
