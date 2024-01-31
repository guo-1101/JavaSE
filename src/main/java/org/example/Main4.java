package org.example;

public class Main4 {
    public static void main(String[] args) {

//        内部类
//        成员内部类

//        成员内部类，也需要具体的对象去创建它的实例。
//        成员内部类和成员方法、成员变量一样，是对象所有的，而不是类所有的，如果我们要使用成员内部类，那么就需要
        Test4 test = new Test4("名字");   //我们首先需要创建对象
//        test.new Inner()  成员内部类的对象
        Test4.Inner inner = test.new Inner();   //成员内部类的类型名称就是 外层.内部类名称
        inner.test();
//        1.在成员内部类中，是可以访问到外层的变量的

//        静态内部类
//        2.前面我们介绍了成员内部类，它就像成员变量和成员方法一样，是属于对象的，
//        同样的，静态内部类就像静态方法和静态变量一样，是属于类的，我们可以直接创建使用。
//        不需要依附任何对象，我们可以直接创建静态内部类的对象
        Test4.Inners inners = new Test4.Inners();   //静态内部类的类名同样是之前的格式，但是可以直接new了
        inners.test();

//        @Override注解 继承的重写，接口的实现都用到它！！

//        匿名内部类
//        匿名内部类，我们可以通过这种方式创建一个临时的实现子类。

//        还记得我们在之前学习的抽象类和接口吗？在抽象类和接口中都会含有某些抽象方法需要子类去实现，
//        我们当时已经很明确地说了不能直接通过new的方式去创建一个抽象类或是接口对象，但是我们可以使用匿名内部类。

//        3.正常情况下，要创建一个抽象类的实例对象，只能对其进行继承，先实现未实现的方法，然后创建子类对象。
//        而我们可以在方法中使用匿名内部类，将其中的抽象方法实现，并直接创建实例对象
//        {}里就相当于一个继承类、子类
        Student4 student = new Student4() {   //在new的时候，后面加上花括号，把未实现的方法实现了
            int a;   //因为本质上就相当于是子类，所以说子类定义一些子类的属性完全没问题
            @Override
            public void test() {
                System.out.println("我是匿名内部类的实现!" + name);   //直接使用父类中的name变量
            }
        };
//        此时这里创建出来的Student对象，就是一个已经实现了抽象方法的对象，这个抽象类直接就定义好了，甚至连名字都没有，就可以直接就创出对象。
//        匿名内部类中同样可以使用类中的属性（因为它本质上就相当于是对应类型的子类）所以说
//        4.同样的，接口也可以通过这种匿名内部类的形式，直接创建一个匿名的接口实现类
        Study4 study = new Study4() {
            @Override
            public void study() {
                System.out.println("我是学习方法！");
            }
        };
        study.study();


//        Lambda表达式
//        1.如果一个接口中有且只有一个待实现的抽象方法，那么我们可以将匿名内部类简写为Lambda表达式
        int aa = 2;
//        aa = 3;
//        6.匿名内部类或者Lambda使用局部变量，要把变量变成final或者隐式final
        Study4 studys = () -> {
            System.out.println("我是学习方法！"+aa);
        };
        studys.study();
//        Lambda表达式的具体规范：
//        标准格式为：([参数类型 参数名称,]...) ‐> { 代码语句，包括返回值 }
//        2.和匿名内部类不同，Lambda仅支持接口，不支持抽象类
//        3.接口内部必须有且仅有一个抽象方法（可以有多个方法，但是必须保证其他方法有默认实现，必须留一个抽象方法出来）

        Study44 studyss = (int a) -> {
            System.out.println("我是学习方法");
            return "今天学会了"+a;    //实际上这里面就是方法体，该咋写咋写
        };
        System.out.println(studyss.study(10));
//        4.如果方法体中只有一个返回语句，可以直接省去花括号和return关键字
//        5.如果参数只有一个，那么可以省去小括号
        Study44 studysss = a -> "今天学会了"+a;


//        方法引用

//        方法引用就是将一个已实现的方法，直接作为接口中抽象方法的实现（当然前提是方法定义得一样才行）
//        方法引用其实本质上就相当于将其他方法的实现，直接作为接口中抽象方法的实现。任何方法都可以通过方法引用作为实现

        Study444 study444 = (a, b) -> a + b;
//        只不过还能更简单，因为Integer类中默认提供了求两个int值之和的方法
//        Integer类中就已经有对应的实现了
//        public static int sum(int a, int b) {
//            return a + b;
//        }
//        此时，我们可以直接将已有方法的实现作为接口的实现
        Study444 study4441 = (a, b) -> Integer.sum(a, b);   //直接使用Integer为我们通过好的求和方法
        System.out.println(study4441.sum(10, 20));
//        我们发现，Integer.sum的参数和返回值，跟我们在Study中定义的完全一样，所以说我们可以直接使用方法引用
        Study444 study4442 = Integer::sum;    //使用双冒号来进行方法引用，静态方法使用 类名::方法名 的形式
        System.out.println(study4442.sum(10, 20));

//        如果是普通从成员方法，我们同样需要使用对象来进行方法引用
        Main4 main = new Main4();
        Study4444 study4444 = main::lbwnb;   //成员方法因为需要具体对象使用，所以说只能使用 对象::方法名 的形式
//        因为现在只需要一个String类型的返回值，由于String的构造方法在创建对象时也会得到一个String类型的结果，所以说
        Study4444 study44441 = String::new;    //没错，构造方法也可以被引用，使用new表示
//        反正只要是符合接口中方法的定义的，都可以直接进行方法引用。

    }
    public String lbwnb(){
        return "卡布奇诺今犹在，不见当年倒茶人。";
    }
}