package com.andy.study.反射;

public class TestClass {
    public TestClass(){}
    private TestClass(int age){
        this.age=age;
    }

    private int age;

    private void setAge(int age){
        this.age=age;
    }

    public int getAge() {
        return age;
    }
}
