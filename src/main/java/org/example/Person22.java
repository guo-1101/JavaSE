package org.example;


//public final class Person22 {  //class前面添加final关键字表示这个类已经是最终形态，不能继承
//}
public class Person22 {   //先定义一个父类
    String name;
    int age;
    String sex;

    public Person22(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void hello(){
        System.out.println("我叫 "+name+"，今年 "+age+" 岁了!");
    }


//    重写注解（可加可不加）
//    eq 快捷键
    @Override   //重写方法可以添加 @Override 注解，有关注解我们会在最后一章进行介绍，这个注解默认情况下可以省略
    public boolean equals(Object obj) {   //重写方法要求与父类的定义完全一致
        if(obj == null) return false;   //如果传入的对象为null，那肯定不相等
        if(obj instanceof Person22) {     //只有是当前类型的对象，才能进行比较，要是都不是这个类型还比什么
            Person22 person22 = (Person22) obj;   //先转换为当前类型，接着我们对三个属性挨个进行比较
            return this.name.equals(person22.name) &&    //字符串内容的比较，不能使用==，必须使用equals方法
                    this.age == person22.age &&       //基本类型的比较跟之前一样，直接==
                    this.sex.equals(person22.sex);
        }
        return false;
    }

//    重写toString
//    to 快捷键
    @Override
    public String toString() {
        return "Person22{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    void test(){
        System.out.println("我是父类");
    }
}
