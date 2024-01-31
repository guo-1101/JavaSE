package org.example;

public class Test4 {
    private final String name;
    public Test4(String name){
        this.name = name;
    }

    public class Inner {   //内部类也是类，所以说里面也可以有成员变量、方法等，甚至还可以继续套娃一个成员内部类
        public void test(){
            System.out.println("我是成员内部类！"+name);
        }

//        String name;
//        public void test(String name){
//            System.out.println("方法参数的name = "+name);    //依然是就近原则，最近的是参数，那就是参数了
//            System.out.println("成员内部类的name = "+this.name);   //在内部类中使用this关键字，只能表示内部类对象
//            System.out.println("成员内部类的name = "+Test4.this.name);   //如果需要指定为外部的对象，那么需要在前面添加外部类型名称
//
////            包括对方法的调用和super关键字的使用，也是一样的
//            this.toString();   //内部类自己的toString方法
//            super.toString();   //内部类父类的toString方法
//            Test.this.toString();   //外部类的toSrting方法
//            Test.super.toString();   //外部类父类的toString方法
//        }
    }

    public static class Inners {
        public void test(){
            System.out.println("我是静态内部类！");
        }
    }
}
