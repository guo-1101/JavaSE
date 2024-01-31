package org.example;

public class Person1 {
//    属性
//    类的成员变量，成员变量相当于是这个类所具有的属性。
    String name;   //直接在类中定义变量，表示类具有的属性
    int age;
    String sex;

//    当然，如果方法没有返回值，我们也可以使用return语句，不需要跟上任何内容，只不过这种情况下使用，仅仅是为了快速结束方法的执行
//    int a  形式参数
    void test(int a){
        if(a == 10) return;    //当a等于10时直接结束方法，后面无论有没有代码都不会执行了
        System.out.println("Hello World!");   //不是的情况就正常执行
    }

//    this表示当前的对象本身

//    有时候我们的方法中可能会出现一些与成员变量重名的变量
//    如果想要在方法中访问到当前对象的属性，那么可以使用this关键字，来明确表示当前类的示例对象本身
    void setName(String name) {
        this.name = name;   //让当前对象的name变量值等于参数传入的值
    }
//    当然，如果方法内没有变量出现重名的情况，那么默认情况下可以不使用this关键字来明确表示当前对象
    String getName() {
        return name;    //这里没有使用this，但是当前作用域下只有对象属性的name变量，所以说直接就使用了
    }

    int sum(int a, int b){
        return a + b;
    }
    double sum(double a, double b){    //为了支持小数加法，我们可以进行一次重载
        return a + b;
    }

    {
        System.out.println("我是代码块");   //代码块中的内容会在对象创建时仅执行一次
    }
    Person1(){

    }
    Person1(String name, int age, String sex){   //跟普通方法是一样的
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    static String info;    //这里我们定义一个info静态变量
    static void test(){
        System.out.println("我是静态方法");
    }

//    public static void test1(){
//        System.out.println("我是静态方法！");
//    }

}
