package org.example;

public class Student222 implements Study222 {   //使用implements关键字来实现接口
    @Override
    public void study() {    //实现接口时，同样需要将接口中所有的抽象方法全部实现
        System.out.println("我会学习！");
    }
}
