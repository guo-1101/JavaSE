package org.example;

//  <类型变量>   T就是类型参数，类型参数要在使用时才会明确的
//可以定义多个
public class Score6<T, U> {   //泛型类需要使用<>，我们需要在里面添加1 - N个类型变量
    String name;
    U id;
    Object value;  //因为Object是所有类型的父类，因此既可以存放Integer也能存放String
    T values;   //T会根据使用时提供的类型自动变成对应类型

    public Score6(String name, U id, Object value, T values) {
        this.name = name;
        this.id = id;
        this.value = value;
        this.values = values;
    }

    public Object getValue() {
        return value;
    }

    public T getValues() {
        return values;
    }
}
