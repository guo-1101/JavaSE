package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main6 {
    public static void main(String[] args) {
//        泛型
        Score6 score = new Score6("数据结构与算法基础", "EP074512", 90, 90);
        Score6 score1 = new Score6("数据结构与算法基础", "EP074512", "优秀", "优秀");  //是String类型的
        Integer number = (Integer) score.getValue();  //获取成绩需要进行强制类型转换，虽然并不是一开始的类型，但是编译不会报错
        System.out.println(number);

//        泛型类
//        1.泛型其实就一个待定类型，我们可以使用一个特殊的名字表示泛型，泛型在定义时并不明确是什么类型，而是需要到使用时才会确定对应的泛型类型。

//        new Score6<String>  构造方法这里可以省new Score6<>
        Score6<String, String> score2 = new Score6<String, String>("计算机网络", "EP074512", "优秀", "优秀");
        //因为现在有了类型变量，在使用时同样需要跟上<>并在其中填写明确要使用的类型
        String values = score2.getValues();   //一旦类型明确，那么泛型就变成对应的类型了
        System.out.println(values);

//        2.泛型将数据类型的确定控制在了编译阶段，在编写代码的时候就能明确泛型的类型，如果类型不符合，将无法通过编译！
//        因为是具体使用对象时才会明确具体类型，所以说静态方法中是不能用的！
//        3.我们在方法中使用待确定类型的变量时，因为此时并不明确具体是什么类型，
//        那么默认会认为这个变量是一个Object类型的变量，因为无论具体类型是什么，一定是Object类的子类
//        4.因为泛型本身就是对某些待定类型的简单处理，不能通过这个不确定的类型变量就去直接创建对象 new T() 和对应的数组，会报错
//        5.如果要让某个变量支持引用任意类型的泛型，那么可以使用?通配符
        Score6<String, ?> score3 = new Score6<>("计算机网络", "EP074512", "优秀", "优秀");
//        6.泛型只能确定为一个引用类型，基本类型是不支持的
//        7.如果是基本类型的数组，因为数组本身是引用类型，所以说是可以的
//        Test<int[]> test = new Test<>(new int[10]);

//        泛型与多态
//        不只是类，包括接口、抽象类，都是可以支持泛型的
        A a = new A();
        Integer i = a.test();
//        或者是继续摆烂，依然使用泛型
        B<String> b = new B<>();
        String j = b.test();
//        继承也是同样的
//        static class A<T> {
//        }
//        static class B extends A<String> {
//        }

//        泛型方法
//        类型变量并不是只能在泛型类中才可以使用，我们也可以定义泛型方法。
//        当某个方法（无论是是静态方法还是成员方法）需要接受的参数类型并不确定时，我们也可以使用泛型来表示
        String str = test("Hello World!");

        String[] strings = new String[1];
        Main6 main = new Main6();
        main.add(strings, "Hello");
        System.out.println(Arrays.toString(strings));

//        泛型的界限
//        在泛型变量的后面添加extends关键字即可指定上界，
//        具体类型只能是我们指定的上界类型或是上界类型的子类，不得是其他类型，否则一律报错。
        Score66<Integer> score4 = new Score66<>("计算机网络", "EP074512", 10);
//        当我们在使用变量时，泛型通配符也支持泛型的界限
        Score66<? extends Integer> score5 = new Score66<>("数据结构与算法", "EP074512", 60);
        Integer o = score5.getValue();
//        只不过下界仅适用于通配符，对于类型变量来说是不支持的。
        Score66<? super Number> score6 = new Score66<>("数据结构与算法基础", "EP074512", 10);
        Object o1 = score6.getValue();


//        函数式接口
//        函数式接口就是JDK1.8专门为我们提供好的用于Lambda表达式的接口，这些接口都可以直接使用Lambda表达式

//        Supplier供给型函数式接口：这个接口是专门用于供给使用的，其中只有一个get方法用于获取需要的对象。
//        比如我们要实现一个专门供给Student对象Supplier，就可以使用
        Supplier<Student> studentSupplier = new Supplier<Student>() {
            @Override
            public Student get() {
                return new Student();
            }
        };
        Supplier<Student> studentSupplier1 = () -> new Student();
//        返回值的类型，参数的数量和Student默认的构造方法匹配的，替换为方法的引用
        Supplier<Student> studentSupplier2 = Student::new;
        Student student = studentSupplier.get();
        student.hello();

//        Consumer消费型函数式接口：这个接口专门用于消费某个对象的。
//        专门消费Student对象的Consumer
        Consumer<Student> STUDENT_CONSUMER = student1 -> System.out.println(student1+" 真好吃！");
        Student student1 = new Student();
        STUDENT_CONSUMER.accept(student1);
//        可以使用andThen方法继续调用
        Student student2 = new Student();
        STUDENT_CONSUMER   //我们可以提前将消费之后的操作以同样的方式预定好
                .andThen(stu -> System.out.println("我是吃完之后的操作！"))
                .andThen(stu -> System.out.println("好了好了，吃饱了！"))
                .accept(student2);   //预定好之后，再执行

//        Function函数型函数式接口：这个接口消费一个对象，然后会向外供给一个对象（前两个的融合体）
//        这里实现了一个简单的功能，将传入的int参数转换为字符串的形式
        Function<Integer, String> INTEGER_STRING_FUNCTION = Object::toString;
        String str1 = INTEGER_STRING_FUNCTION.apply(10);
        System.out.println(str1);
//        可以使用compose将指定函数式的结果作为当前函数式的实参
        String str2 = INTEGER_STRING_FUNCTION
                .compose(String::length)   //将此函数式的返回值作为当前实现的实参
                .apply("lbwnb");   //传入上面函数式需要的参数
        System.out.println(str2);
//        andThen可以将当前实现的返回值进行进一步的处理，得到其他类型的值
        Boolean str3 = INTEGER_STRING_FUNCTION
                .andThen(String::isEmpty)   //在执行完后，返回值作为参数执行andThen内的函数式，最后得到的结果就是最终的结果了
                .apply(10);
        System.out.println(str3);

//        Predicate断言型函数式接口：接收一个参数，然后进行自定义判断并返回一个boolean结果。
        Predicate<Student> STUDENT_PREDICATE = student3 -> student3.score >= 60;
        Student student3 = new Student();
        student3.score = 80;
        if(STUDENT_PREDICATE.test(student3)) {  //test方法的返回值是一个boolean结果
            System.out.println("及格了，真不错，今晚奖励自己一次");
        } else {
            System.out.println("不是，Java都考不及格？隔壁初中生都在打ACM了");
        }
//        可以使用组合条件判断
        Student student4 = new Student();
        student4.score = 80;
        boolean b1 = STUDENT_PREDICATE
                .and(stu -> stu.score > 90)   //需要同时满足这里的条件，才能返回true
                .test(student4);
        if(!b1) System.out.println("Java到现在都没考到90分？你的室友都拿国家奖学金了");
//        提供了一个对应的实现，用于判断两个对象是否相等
        Predicate<String> predicate = Predicate.isEqual("Hello World");   //这里传入的对象会和之后的进行比较
        System.out.println(predicate.test("Hello World"));

//        Comparator比较器
//        (a, b) -> b - a


//        判空包装
//        判空包装类Optional
        test1(null);
        test2("dasffa");


    }
//    泛型与多态
    static class A implements Study6<Integer> {
        //在实现接口或是继承父类时，如果子类是一个普通类，那么可以直接明确对应类型
        @Override
        public Integer test() {
            return null;
        }
    }
    static class B<T> implements Study6<T> {
        //让子类继续为一个泛型类，那么可以不用明确
        @Override
        public T test() {
            return null;
        }
    }
//    泛型方法
    private static <T> T test(T t){   //在返回值类型前添加<>并填写泛型变量表示这个是一个泛型方法
        return t;
    }
    private <T> void add(T[] arr, T t){
        arr[0] = t;
    }

    public static class Student {
        public int score;
        public void hello(){
            System.out.println("我是学生！");
        }
    }

//    判空包装
    private static void test1(String str){   //传入字符串，如果不是空串，那么就打印长度
        if(str == null) return;   //这样就可以防止null导致的异常了
        if(!str.isEmpty()) {
            System.out.println("字符串长度为："+str.length());
        }
    }
    private static void test2(String str){
        Optional
//                ofNullable包装
                .ofNullable(str)   //将传入的对象包装进Optional中
//                ifPresent如果存在
                .ifPresent(s -> {
                    if(!str.isEmpty()) {
                        System.out.println("长度为："+str.length());
                    }
                });
        //如果不为空，则执行这里的Consumer实现

//        包装之后，我们再获取时可以优雅地处理为空的情况
        String s = Optional.ofNullable(str).get();   //get方法可以获取被包装的对象引用，但是如果为空的话，会抛出异常
        System.out.println(s);
//        我们可以对于这种有可能为空的情况进行处理，如果为空，那么就返回另一个备选方案
        String s1 = Optional.ofNullable(str).orElse("我是为null的情况备选方案");
        System.out.println(s1);
//        还可以将包装的类型直接转换为另一种类型
        Integer i = Optional
                .ofNullable(str)
                .map(String::length)   //使用map来进行映射，将当前类型转换为其他类型，或者是进行处理
                .orElse(-1);
        System.out.println(i);
    }
}
