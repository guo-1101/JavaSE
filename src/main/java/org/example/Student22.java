package org.example;

public class Student22 extends Person22{   //学生类

    String name;   //子类中同样可以定义name属性
    public Student22(String name, int age, String sex) {
        super(name, age, sex);
    }
    public void study(){
        System.out.println("我的名字是 "+name+"，我在学习！");   //可以直接访问父类中定义的name属性
        System.out.println("我的名字是 "+super.name+"，我在学习！");   //这里使用super.name来表示需要的是父类的name变量
    }
//    重写父类方法
    @Override
    void test() {
        super.test();   //调用父类的实现
        System.out.println("我是子类");
    }
}
