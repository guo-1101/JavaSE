package org.example;

//都不可以继承
public final class Main1217B extends Main1217A {   //在子类final，彻底封死
}

//继续向下指定
//public sealed class B extends A {
//}

//打开 所有都可以继承，B指定non-sealed主动放弃了密封特性。
//public non-sealed class Main1217B extends Main1217A {
//}

