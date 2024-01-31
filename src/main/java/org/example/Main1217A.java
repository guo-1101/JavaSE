package org.example;

//指定B继承A
public sealed class Main1217A permits Main1217B{   //在class关键字前添加sealed关键字，表示此类为密封类型，permits后面跟上允许继承的类型，多个子类使用逗号隔开

}

//public final class Main1217A {   //添加final关键字后，不允许对此类继承
//}
