package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;

public class Main3 {
    public static void main(String[] args) {

//        基本类型包装类

//        其中能够表示数字的基本类型包装类，继承自Number类，对应关系如下表：
//        char -> Character
//        boolean -> Boolean
//        byte -> Byte -> Number
//        short -> Short -> Number
//        int -> Integer -> Number
//        long -> Long -> Number
//        float -> Float -> Number
//        double -> Double -> Number

//        包装类实际上就是将我们的基本数据类型，封装成一个类（运用了封装的思想）

//        创建一个Integer类型的引用变量
        Integer i = 10;    //将10包装为一个Integer类型的变量

//        包装类型自动装箱机制
//        我们可以直接将一个对应的基本类型值作为对应包装类型引用变量的值
        Integer i1 = 10;    //将int类型值作为包装类型使用
//        上面的写法跟这里是等价的
        Integer i11 = Integer.valueOf(10);

//        包装类型自动拆箱机制
//        这里本质上就是被自动包装成了一个Integer类型的对象
        Integer i2 = 10;
        int a = i2;
//        实际上上面的写法本质上就是
        Integer i22 = 10;
        int a1 = i22.intValue();   //通过此方法变成基本类型int值

//        字符串转Integer有多个方法
        Integer i3 = Integer.valueOf("5555");
        Integer i4 = Integer.parseInt("5555");
        System.out.println(i3);
        System.out.println(i4);

//        特殊包装类

//        其中第一个是用于整数计算超大数字的BigInteger
        BigInteger i5 = BigInteger.valueOf(Long.MAX_VALUE);
        i5 = i5.multiply(BigInteger.valueOf(Long.MAX_VALUE));   //即使是long的最大值乘以long的最大值，也能给你算出来
        System.out.println(i5);
        BigInteger i6 = BigInteger.valueOf(Long.MAX_VALUE);
        i6 = i6.pow(100);   //long的最大值来个100次方吧
        System.out.println(i6);

//        BigDecimal可以实现小数的精确计算。
        BigDecimal i7 = BigDecimal.valueOf(10);
        i7 = i7.divide(BigDecimal.valueOf(3), 100, RoundingMode.CEILING);
        //计算10/3的结果，精确到小数点后100位
        //RoundingMode是舍入模式，就是精确到最后一位时，该怎么处理，这里CEILING表示向上取整
        System.out.println(i7);
//        但是注意，对于这种结果没有终点的，无限循环的小数，我们必须要限制长度，否则会出现异常。


//        数组

//        数组是一个引用类型，继承Object的引用类型
//        基本类型使用final不可以改变值
//        final int aa = 1;
//        aa = 2;
//        引用类型使用final，不能改变它引用的对象，指针永远指向这个对象
//        final int[] aaa = new int[3];
//        aaa = new int[]{1, 2, 3};

//        数组是相同类型数据的有序集合
        int[] array;   //类型[]就表示这个是一个数组类型
//        1.注意，数组类型比较特殊，它本身也是类，即使是基本类型的数组，也是以对象的形式存在的，并不是基本数据类型。
//        所以，我们要创建一个数组，同样需要使用new关键字
        int[] array1 = new int[10];   //在创建数组时，需要指定数组长度，也就是可以容纳多个int变量的值
//        2.除了上面这种方式之外，我们也可以使用其他方式
//        类型[] 变量名称 = new 类型[数组大小];
//        类型[] 变量名称 = new 类型[]{...};  //静态初始化（直接指定值和大小）
//        类型[] 变量名称 = {...};   //同上，但是只能在定义时赋值

//        创建出来的数组每个位置上都有默认值，如果是引用类型，就是null，如果是基本数据类型，就是0，或者是false，
        int[] array2 = new int[10];
        System.out.println("数组的第一个元素为："+array2[0]);  //使用 变量名[下标] 的方式访问
//        为数组的元素赋值
        int[] array3 = new int[10];
        array3[0] = 888;
        System.out.println("数组的第一个元素为："+array3[0]);
//        因为数组本身也是一个对象，数组对象也是具有属性的，比如长度
        int[] array4 = new int[10];
        System.out.println("当前数组长度为："+array4.length);   //length属性是int类型的值，表示当前数组长度，长度是在一开始创建数组的时候就确定好的
//        3.注意，这个length是在一开始就确定的，而且是final类型的，不允许进行修改。

//        要打印整个数组中所有的元素，得一个一个访问
        int[] array6 = new int[10];
        for (int i8 = 0; i8 < array6.length; i8++) {
            System.out.print(array6[i8] + " ");
        }
//        可以使用简化版的for语句foreach语法来遍历数组中的每一个元素
        int[] array7 = new int[10];
        for (int i9 : array7) {    //int i就是每一个数组中的元素，array就是我们要遍历的数组
            System.out.print(i9+" ");   //每一轮循环，i都会更新成数组中下一个元素
        }

//        多维数组

        int[][] arrays = new int[2][10];    //数组类型数组那么就要写两个[]了
        int[][] arrs = { {1, 2},
                {3, 4},
                {5, 6}};   //一个三行两列的数组
        System.out.println(arrs[2][1]);   //访问第三行第二列的元素
//        在访问多维数组时，我们需要使用多次[]运算符来得到对应位置的元素。如果我们要遍历多维数组话，那么就需要多次嵌套循环
        int[][] arrs1 = new int[][]{{1, 2, 3},
                {3, 4},
                {5, 6}};
        for (int i10 = 0; i10 < arrs1.length; i10++) {    //要遍历一个二维数组，那么我们得一列一列一行一行地来
            for (int j = 0; j < arrs1[i10].length; j++) {
                System.out.println(arrs1[i10][j]);
            }
        }

//        可变长参数

//        如果同时存在其他参数，那么可变长参数只能放在最后
        test(1, 2, "啊", "吧");


//        字符串

//        1.字符串类是一个比较特殊的类，字符串中的字符一旦确定，无法进行修改，只能重新创建。

//        String类
//        String本身也是一个类，只不过它比较特殊，每个用双引号括起来的字符串，都是String类型的一个实例对象
        String str = "Hello World!";
        String str1 = new String("Hello World!");  //这种方式就是创建一个新的对象
//        如果我们仅仅是想要判断两个字符串的内容是否相同，不要使用==，String类重载了equals方法用于判断和比较内容是否相同
//        字符串的内容比较，一定要用equals

//        字符数组和字符串之间是可以快速进行相互转换的
        String str2 = "Hello World";
        char[] chars2 = str2.toCharArray();
        System.out.println(chars2);
        char[] chars3 = new char[]{'奥', '利', '给'};
        String str3 = new String(chars3);
        System.out.println(str3);

//        StringBuilder类
        StringBuilder builder = new StringBuilder();   //一开始创建时，内部什么都没有
        builder.append("AAA");   //我们可以使用append方法来讲字符串拼接到后面
        builder.append("BBB");
        System.out.println(builder.toString());   //当我们字符串编辑完成之后，就可以使用toString转换为字符串了
        StringBuilder builder1 = new StringBuilder("AAABBB");   //在构造时也可以指定初始字符串
        builder.delete(2, 4);   //删除2到4这个范围内的字符
        System.out.println(builder.toString());

//        正则表达式
        String strs = "oooo";
        //matches方法用于对给定正则表达式进行匹配，匹配成功返回true，否则返回false
        System.out.println(str.matches("o+"));   //+表示对前面这个字符匹配一次或多次

//        https://www.runoob.com/regexp/regexp-syntax.html


//        数学工具类
//        Math也是java.lang包下的类，所以说默认就可以直接使用
        System.out.println(Math.pow(5, 3));   //我们可以使用pow方法直接计算a的b次方
        Math.abs(-1);    //abs方法可以求绝对值
        Math.max(19, 20);    //快速取最大值
        Math.min(2, 4);   //快速取最小值
        Math.sqrt(9);    //求一个数的算术平方根
        Math.ceil(4.5);    //通过使用ceil来向上取整
        Math.floor(5.6);   //通过使用floor来向下取整

//        生成一个随机数，我们需要使用Random类来生成
        Random random = new Random();   //创建Random对象
        for (int i12 = 0; i12 < 30; i12++) {
            System.out.print(random.nextInt(100)+" ");  //nextInt方法可以指定创建0 - x之内的随机数
        }

//        数组工具类
//        数组工具类Arrays

//        打印数组，可以直接通过toString方法转换字符串
        int[] arr = new int[]{1, 4, 5, 8, 2, 0, 9, 7, 3, 6};
        System.out.println(Arrays.toString(arr));
//        将数组进行排序
        int[] arr1 = new int[]{1, 4, 5, 8, 2, 0, 9, 7, 3, 6};
        Arrays.sort(arr1);    //可以对数组进行排序，将所有的元素按照从小到大的顺序排放
        System.out.println(Arrays.toString(arr1));
//        数组中的内容也可以快速进行填充
        int[] arr2 = new int[10];
        Arrays.fill(arr2, 5);
        System.out.println(Arrays.toString(arr2));
//        可以快速地对一个数组进行拷贝
        int[] arr3 = new int[]{1, 2, 3, 4, 5};
        int[] target = Arrays.copyOf(arr3, 5);
        System.out.println(Arrays.toString(target));   //拷贝数组的全部内容，并生成一个新的数组对象
        int[] arr4 = new int[]{1, 2, 3, 4, 5};
        int[] target4 = Arrays.copyOfRange(arr4, 3, 5);   //也可以只拷贝某个范围内的内容
        System.out.println(Arrays.toString(target4));
//        我们也可以将一个数组中的内容拷贝到其他数组中
        int[] arr5 = new int[]{1, 2, 3, 4, 5};
        int[] target5 = new int[10];
        System.arraycopy(arr5, 0, target5, 0, 5);   //使用System.arraycopy进行搬运
        System.out.println(Arrays.toString(target5));
//        对于一个有序的数组（从小到大排列）我们可以使用二分搜索快速找到对应的元素在哪个位置
        int[] arr6 = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.binarySearch(arr6, 5));   //二分搜索仅适用于有序数组

    }
//    可以传入0 - N个对应类型的实参
    public static void test(int a, int b, String... strings){
//        可变长参数本质就是一个数组
        for (String string : strings) {
            System.out.println(string);   //遍历打印数组中每一个元素
        }
    }
}
