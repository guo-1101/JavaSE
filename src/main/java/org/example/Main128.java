package org.example;

//添加了此注解的接口，都支持lambda表达式，符合函数式接口定义
@FunctionalInterface
public interface Main128 {   //接口类型
    String test(Integer i);    //只有这一个抽象方法，且接受一个int类型参数，返回一个String类型结果
//    public abstract void run();   //有且仅有一个抽象方法，此方法返回值为void，且没有参数
}
