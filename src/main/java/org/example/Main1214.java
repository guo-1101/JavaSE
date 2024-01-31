package org.example;

public class Main1214 {
    private final String name;
    public Main1214(String name) {
        this.name = name;
    }
//    比如我们之前要重写一个类的equals方法
//    @Override
//    public boolean equals(Object obj) {
//        if(obj instanceof Main1214) {   //首先判断是否为Student类型
//            Main1214 main1214 = (Main1214) obj;  //如果是，那么就类型转换
//            return main1214.name.equals(this.name);  //最后比对属性是否一样
//        }
//        return false;
//    }
//    在之前我们一直都是采用这种先判断类型，然后类型转换，最后才能使用的方式，
//    但是这个版本instanceof加强之后，我们就不需要了，我们可以直接将student替换为模式变量
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Main1214 main1214) {   //在比较完成的屁股后面，直接写变量名字，而这个变量就是类型转换之后的
            return main1214.name.equals(this.name);  //下面直接用，是不是贼方便
        }
        return false;
    }
//    在使用instanceof判断类型成立后，会自动强制转换类型为指定类型，简化了我们手动转换的步骤。
}
