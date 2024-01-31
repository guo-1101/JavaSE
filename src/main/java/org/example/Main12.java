package org.example;

import java.util.*;
import java.util.stream.Stream;

public class Main12 {
    public static void main(String[] args) {

//        Java 8
//        Lambda表达式
//        我们在某些情况下可能需要用到匿名内部类
//        新建一个线程
        Thread thread = new Thread(new Runnable() {   //创建一个实现Runnable的匿名内部类
            @Override
            public void run() {   //具体的实现逻辑
                System.out.println("Hello World!");
            }
        });
        thread.start();
//        在创建Thread时，我们需要传入一个Runnable接口的实现类，来指定具体的在新的线程中要执行的任务，
//        相关的逻辑需要我们在run()方法中实现，这时为了方便，我们就直接使用匿名内部类的方式传入一个实现，但是这样的写法实在是太过臃肿了。

        Thread thread1 = new Thread(() -> {
            System.out.println("Hello World!");  //只需留下我们需要具体实现的方法体
        });
        thread1.start();

//        但是注意，它的底层其实并不只是简简单单的语法糖替换，而是通过invokedynamic指令实现的，
//        不难发现，匿名内部类会在编译时创建一个单独的class文件，但是lambda却不会，间接说明编译之后lambda并不是以匿名内部类的形式存在的

//        我们来看一下Lambda表达式的具体规范：
//        标准格式为：([参数类型 参数名称,]...) ‐> { 代码语句，包括返回值 }
//        和匿名内部类不同，Lambda仅支持接口，不支持抽象类
//        接口内部必须有且仅有一个抽象方法（可以有多个方法，但是必须保证其他方法有默认实现，必须留一个抽象方法出来）

        Main128 main128 = (Integer i) -> { return i+""; };  //这里我们就简单将i转换为字符串形式
//        不过还可以进行优化，首先方法参数类型是可以省略的
        Main128 main1281 = (i) -> { return i+""; };
//        由于只有一个参数，可以不用添加小括号（多个参数时需要）
        Main128 main1282 = i -> { return i+""; };
//        由于仅有返回语句这一行，所以可以直接写最终返回的结果，并且无需花括号
        Main128 main1283 = i -> i+"";

        System.out.println(main1283.test(2));

        Main128 main1284 = new Main128() {
            @Override
            public String test(Integer i) {
                return i+"";
            }
        };
        System.out.println(main1284.test(2));

//        当然，除了我们手动编写接口中抽象方法的方法体之外，如果已经有实现好的方法，是可以直接拿过来用的
//        现在有一个静态方法，刚好匹配接口中抽象方法的返回值和参数列表
//        所以，我们可以直接将此方法，作为lambda表达式的方法体实现。其实这就是一种方法引用，引用了一个方法过来
        Main128 tests = i -> impl(i);
        Main128 testss = Main12::impl;    //使用 类名::方法名称 的形式来直接引用一个已有的方法作为实现
        System.out.println(tests.test(1));
        System.out.println(testss.test(2));


//        Optional类
//        可以将任何的变量包装进Optional类中使用
        hello("AAAA");
        hello(null);

//        Optional类，它很好的解决了判空问题
        test(null);
        String str1 = null;
        Optional.ofNullable(str1).ifPresentOrElse(s -> {  //通过使用ifPresentOrElse，我们同时处理两种情况
            System.out.println("被包装的元素为："+s);     //第一种情况和ifPresent是一样的
        }, () -> {
            System.out.println("被包装的元素为null");   //第二种情况是如果为null的情况
        });
//        也可以使用or()方法快速替换为另一个Optional类
        String str2 = null;
        Optional.ofNullable(str2)
                .or(() -> Optional.of("AAA"))   //如果当前被包装的类不是null，依然返回自己，但是如果是null，那就返回Supplier提供的另一个Optional包装
                .ifPresent(System.out::println);

//        Java 9
//        在之前，如果我们想要快速创建一个Map只能
        Map<String, Integer> map = new HashMap<>();   //要快速使用Map，需要先创建一个Map对象，然后再添加数据
        map.put("AAA", 19);
        map.put("BBB", 23);
        System.out.println(map);

//        而在Java 9之后，我们可以直接通过of方法来快速创建了
        Map<String, Integer> maps = Map.of("AAA", 18, "BBB", 20);  //直接一句搞定
        System.out.println(maps);
//        但是注意，通过这种方式创建的Map和通过Arrays创建的List比较类似，也是无法进行修改的。

        Set<String> set = Set.of("BBB", "CCC", "AAA");  //注意Set中元素顺序并不一定你的添加顺序
        List<String> list = List.of("AAA", "CCC", "BBB");   //好耶，再也不用Arrays了

        Stream
                .of("A", "B", "B", "C")   //这里我们可以直接将一些元素封装到Stream中
                .filter(s -> s.equals("B"))   //通过过滤器过滤
                .distinct()   //去重
                .forEach(System.out::println);   //最后打印
//        Stream
//                .of(null)   //如果传入null会报错
//                .forEach(System.out::println);
        Stream
                .ofNullable(null) //使用新增的ofNullable方法，这样就不会了，不过这样的话流里面就没东西了
                .forEach(System.out::println);
//        通过迭代快速生成一组数据
        Stream
                .iterate(0, i -> i + 1)   //Java8只能像这样生成无限的流，第一个参数是种子，就是后面的UnaryOperator的参数i一开始的值，最后会返回一个值作为i的新值，每一轮都会执行UnaryOperator并生成一个新值到流中，这个是源源不断的，如果不加limit()进行限制的话，将无限生成下去。
                .limit(20)   //这里限制生成20个
                .forEach(System.out::println);
        Stream
                //不知道怎么写？参考一下：for (int i = 0;i < 20;i++)
                .iterate(0, i -> i < 20, i -> i + 1)  //快速生成一组0~19的int数据，中间可以添加一个断言，表示什么时候结束生成
                .forEach(System.out::println);
//        对数据的截断操作，比如我们希望在读取到某个元素时截断，不再继续操作后面的元素
        Stream
                .iterate(0, i -> i + 1)
                .limit(20)
                .takeWhile(i -> i < 10)   //当i小于10时正常通过，一旦大于等于10直接截断
                .forEach(System.out::println);
        Stream
                .iterate(0, i -> i + 1)
                .limit(20)
                .dropWhile(i -> i < 10)   //和上面相反，上来就是截断状态，只有当满足条件时再开始通过
                .forEach(System.out::println);

//        在Java 8中，接口中的方法支持添加default关键字来添加默认实现
//        而在Java 9中，接口再次得到强化，现在接口中可以存在私有方法了
//        注意私有方法必须要提供方法体，因为权限为私有的，也只有这里能进行方法的具体实现了，并且此方法只能被接口中的其他私有方法或是默认实现调用。
//        public interface Test {
//            default void test(){
//                System.out.println("我是test方法默认实现");
//                this.inner();   //接口中方法的默认实现可以直接调用接口中的私有方法
//            }
//            private void inner(){   //声明一个私有方法
//                System.out.println("我是接口中的私有方法！");
//            }
//        }

//        Java 10
//        var关键字仅适用于局部变量，我们是没办法在其他地方使用的，比如类的成员变量
//        局部变量
        var a = "哈哈";

//        Java 11
        var str = "AB\nC\nD";
        str
                .lines()   //根据字符串中的\n换行符进行切割，分为多个字符串，并转换为Stream进行操作
                .forEach(System.out::println);

//        Java 12
//        新的switch语法：switch表达式
//        var res = switch (obj) {   //这里和之前的switch语句是一样的，但是注意这样的switch是有返回值的，所以可以被变量接收
//            case [匹配值, ...] -> "优秀";   //case后直接添加匹配值，匹配值可以存在多个，需要使用逗号隔开，使用 -> 来返回如果匹配此case语句的结果
//            case ...   //根据不同的分支，可以存在多个case
//                default -> "不及格";   //注意，表达式要求必须涵盖所有的可能，所以是需要添加default的
//        };

//        如果我们并不是能够马上返回，而是需要做点什么其他的工作才能返回结果呢？
//        var res = switch (obj) {   //增强版switch语法
//            case [匹配值, ...] -> "优秀";
//                default -> {   //我们可以使用花括号来将整套逻辑括起来
//                    //... 我是其他要做的事情
//                    yield  "不及格";  //注意处理完成后需要返回最终结果，但是这样并不是使用return，而是yield关键字
//                }
//        };
//        或
//        var res = switch (args.length) {   //增强版switch语法
//            case [匹配值, ...]:
//                yield "AAA";   //传统的:写法，通过yield指定返回结果，同样不需要break
//            default:
//                System.out.println("默认情况");
//                yield "BBB";
//        };

//        Java 14
//        新的instanceof语法

//        java 16
//        记录类型
//        在实际开发中，很多的类仅仅只是充当一个实体类罢了，保存的是一些不可变数据，比如我们从数据库中查询的账户信息，最后会被映射为一个实体类
//        Lombok可以说是简化代码的神器了，他能在编译时自动生成getter和setter、构造方法、toString()方法等实现。
//        记录类型本质上也是一个普通的类，不过是final类型且继承自java.lang.Record抽象类的，
//        它会在编译时，会自动编译出 public get hashcode 、equals、toString 等方法。

//        Java 17
//        密封类型
//        密封类的作用就是限制类的继承。

//        实际上在之前我们如果不希望别人继承我们的类，可以直接添加final关键字
//        这样有一个缺点，如果添加了final关键字，那么无论是谁，包括我们自己也是没办法实现继承的，
//        但是现在我们有一个需求，只允许我们自己写的类继承A，但是不允许别人写的类继承A。

//        密封类型有以下要求：
//        可以基于普通类、抽象类、接口，也可以是继承自其他接抽象类的子类或是实现其他接口的类等。
//        必须有子类继承，且不能是匿名内部类或是lambda的形式。
//        sealed写在原来final的位置，但是不能和final、non-sealed关键字同时出现，只能选择其一。
//        继承的子类必须显式标记为final、sealed或是non-sealed类型。
//        标准的声明格式如下
//        public sealed [abstract] [class/interface] 类名 [extends 父类] [implements 接口, ...] permits [子类, ...]{
//            //里面的该咋写咋写
//        }
//        注意子类格式为
//        public [final/sealed/non-sealed] class 子类 extends 父类 {   //必须继承自父类
//            //final类型：任何类不能再继承当前类，到此为止，已经封死了。
//            //sealed类型：同父类，需要指定由哪些类继承。
//            //non-sealed类型：重新开放为普通类，任何类都可以继承。
//        }

//        当然我们也可以通过反射来获取类是否为密封类型
        Class<Main1217A> main1217AClass = Main1217A.class;
        System.out.println(main1217AClass.isSealed());   //是否为密封
    }
//    8
    public static String impl(Integer i){   //现在有一个静态方法，刚好匹配接口中抽象方法的返回值和参数列表
        return "我是已经存在的实现"+i;
    }

    public static void hello(String str){
        Optional
                .ofNullable(str)   //将str包装进Optional
                .ifPresent(s -> {   //ifPresent表示只有对象不为null才会执行里面的逻辑，实现一个Consumer（接受一个参数，返回值为void）
                    System.out.println(s);
                });
//        println也是接受一个String参数，返回void，所以这里使用我们前面提到的方法引用的写法
//        Optional
//                .ofNullable(str)   //将str包装进Optional
//                .ifPresent(System.out::println);
//        还可以直接从Optional中获取被包装的对象
        System.out.println(Optional.ofNullable(str).get());
//        不过此时当被包装的对象为null时会直接抛出异常，当然，我们还可以指定如果get的对象为null的替代方案
        System.out.println(Optional.ofNullable(str).orElse("VVV"));   //orElse表示如果为空就返回里面的内容
    }
    public static void test(String s){
        //比如现在我们想执行 System.out.println(str.toLowerCase())
        //但是由于我们不清楚给进来的str到底是不是null，如果是null的话会引起空指针异常
        //但是去单独进行一次null判断写起来又不太简洁，这时我们可以考虑使用Optional进行包装
        Optional
                .ofNullable(s)
                .ifPresent(str -> System.out.println(str.toLowerCase()));
    }

//    12
    /**
     * 传入分数（范围 0 - 100）返回对应的等级：
     *      100-90：优秀
     *      70-80：良好
     *      60-70：及格
     *      0-60：寄
     * @param score 分数
     * @return 等级
     */
    public static String grade(int score){
        score /= 10;  //既然分数段都是整数，那就直接整除10
        String res = null;
        switch (score) {
            case 10:
            case 9:
                res =  "优秀";   //不同的分数段就可以返回不同的等级了
                break;   //别忘了break，不然会贯穿到后面
            case 8:
            case 7:
                res = "良好";
                break;
            case 6:
                res = "及格";
                break;
            default:
                res = "不及格";
                break;
        }
        return res;
    }
    public static String grade1(int score){
        score /= 10;  //既然分数段都是整数，那就直接整除10
        return switch (score) {   //增强版switch语法
            case 10, 9 -> "优秀";   //语法那是相当的简洁，而且也不需要我们自己考虑break或是return来结束switch了（有时候就容易忘记，这样的话就算忘记也没事了）
            case 8, 7 -> "良好";
            case 6 -> "及格";
            default -> "不及格";
        };
    }
}
