package org.example;

public class Person2 {
    private String name;    //现在类的属性只能被自己直接访问
    private int age;
    private String sex;

    public Person2(String name, int age, String sex) {   //构造方法也要声明为公共，否则对象都构造不了
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;    //想要知道这个对象的名字，必须通过getName()方法来获取，并且得到的只是名字值，外部无法修改
    }
    public String getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }

//    比如小明可以修改名字，但是名字中不能包含"小"这个字
    public void setName(String name) {
        if(name.contains("小")) return;
        this.name = name;
    }

    private Person2(){}   //不允许外部使用new关键字创建对象

    public static Person2 getInstance() {   //而是需要使用我们的独特方法来生成对象并返回
        return new Person2();
    }
}
