package org.example;

import java.util.*;
import java.util.concurrent.Flow;
import java.util.stream.Collectors;

public class Main8 {
    public static void main(String[] args) {

//        集合类
//        集合其实与我们数学中的集合是差不多的概念，集合表示一组对象，每一个对象我们都可以称其为元素。

//        集合跟数组一样，可以表示同样的一组元素，但是他们的相同和不同之处在于：
//        它们都是容器，都能够容纳一组元素。
//        不同之处：
//        数组的大小是固定的，集合的大小是可变的。
//        数组可以存放基本数据类型，但集合只能存放对象。
//        数组存放的类型只能是一种，但集合可以有不同种类的元素。

//        1.集合根接口Collection接口
//        实现类：
//        List列表
//        List列表（线性表），线性表支持随机访问。
//        2.ArrayList，它的底层是用数组实现的，内部维护的是一个可动态进行扩容的数组，同时实现自List接口。

//        List是集合类型的一个分支，它的主要特性有：
//        3.是一个有序的集合，插入元素默认是插入到尾部，按顺序从前往后存放，每个元素都有一个自己的下标位置，列表中允许存在重复元素
//        在List接口中，定义了列表类型需要支持的全部操作，List直接继承自前面介绍的Collection接口，

//        如果我们要使用一个集合类，我们会使用接口的引用
        List<String> list = new ArrayList<>();   //使用接口的引用来操作具体的集合类实现，是为了方便日后如果我们想要更换不同的集合类实现，而且接口中本身就已经定义了主要的方法，所以说没必要直接用实现类
        list.add("上头");   //使用add添加元素
        list.add("上头啊");
        System.out.println(list);
//        断言型函数式接口
        list.removeIf(s -> s.length() == 3);
        System.out.println(list);

        List<Integer> list1 = new ArrayList<>();
        list1.add(10);   //添加Integer的值10
        list1.remove((Integer) 10);   //注意，不能直接用10，默认情况下会认为传入的是int类型值，删除的是下标为10的元素，我们这里要删除的是刚刚传入的值为10的Integer对象
        System.out.println(list1);   //可以看到，此时元素成功被移除

//        集合类是支持嵌套使用的，一个集合中可以存放多个集合
        List<List<String>> list2 = new LinkedList<>();
        list2.add(new LinkedList<>());   //集合中的每一个元素就是一个集合，这个套娃是可以一直套下去的
        System.out.println(list2.get(0).isEmpty());
//        在Arrays工具类中，我们可以快速生成一个只读的List
        List<String> list3 = Arrays.asList("A", "B", "C");   //非常方便
        System.out.println(list3);
//        要生成正常使用的，我们可以将这个只读的列表作为参数传入
        List<String> list4 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        System.out.println(list4);
//        也可以利用静态代码块
        List<String> list5 = new ArrayList<>() {{   //使用匿名内部类（匿名内部类在Java8无法使用钻石运算符，但是之后的版本可以）
            add("A");
            add("B");
            add("C");
        }};
        System.out.println(list5);

//        另一个列表实现类，LinkedList同样是List的实现类，只不过它是采用的链式实现，也就是我们之前讲解的链表，
//        只不过它是一个双向链表，也就是同时保存两个方向，LinkedList的使用和ArrayList的使用几乎相同。

//        迭代器

        List<String> list6 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        for (String s : list6) {   //集合类同样支持这种语法
            System.out.println(s);
        }
//        迭代器的使用是一次性的，用了之后就不能用了，如果需要再次进行遍历操作，那么需要重新生成一个迭代器对象。
//        为了简便，我们可以直接使用foreach语法来快速遍历集合类，效果是完全一样的
//        通过调用iterator方法快速获取当前集合的迭代器
//        Iterator迭代器本身也是一个接口，由具体的集合实现类来根据情况实现
        Iterator<String> iterator = list6.iterator();
        while (iterator.hasNext()) {    //每次循环一定要判断是否还有元素剩余
            System.out.println(iterator.next());  //如果有就可以继续获取到下一个元素
        }

//        在Java8提供了一个支持Lambda表达式的forEach方法，这个方法接受一个Consumer，也就是对遍历的每一个元素进行的操作
        list6.forEach(System.out::println);
        list6.forEach(s -> System.out.println(s));

//        ListIterator，这个迭代器是针对于List的强化版本，增加了更多方便的操作，
//        因为List是有序集合，所以它支持两种方向的遍历操作，不仅能从前向后，也可以从后向前
//        这种迭代器因为能够双向遍历，所以说可以反复使用。
        ListIterator<String> iterator1 = list6.listIterator();
        iterator1.next();   //此时得到A
        iterator1.set("X");  //将A原本位置的上的元素设定为成新的
        System.out.println(list6);


//        Set集合
//        接口中定义的方法都是Collection中直接继承的，因此，Set支持的功能其实也就和Collection中定义的差不多：
//        4.不允许出现重复元素
//        不支持随机访问（不允许通过下标访问）

//        5.HashSet，它的底层就是采用哈希表实现的，我们可以非常高效的从HashSet中存取元素
        Set<String> set = new HashSet<>();
        System.out.println(set.add("AAA"));   //这里我们连续插入两个同样的字符串
        System.out.println(set.add("AAA"));
        System.out.println(set);   //可以看到，最后实际上只有一个成功插入了
//        在Set接口中并没有定义支持指定下标位置访问的添加和删除操作，我们只能简单的删除Set中的某个对象
        Set<String> set1 = new HashSet<>();
        System.out.println(set1.add("AAA"));
        System.out.println(set1.remove("AAA"));
        System.out.println(set1);
//        由于底层采用哈希表实现，所以说无法维持插入元素的顺序
        Set<String> set3 = new HashSet<>();
        set3.addAll(Arrays.asList("A", "0", "-", "+"));
        System.out.println(set3);
//        就是想要使用维持顺序的Set集合呢？我们可以使用LinkedHashSet，LinkedHashSet底层维护的不再是一个HashMap，
//        而是LinkedHashMap，它能够在插入数据时利用链表自动维护顺序，因此这样就能够保证我们插入顺序和最后的迭代顺序一致了。
        Set<String> set4 = new LinkedHashSet<>();
        set4.addAll(Arrays.asList("A", "0", "-", "+"));
        System.out.println(set4);
//        TreeSet，它会在元素插入时进行排序
        TreeSet<Integer> set5 = new TreeSet<>();
        set5.add(1);
        set5.add(3);
        set5.add(2);
        System.out.println(set5);
//        也可以自定义排序规则
        TreeSet<Integer> set6 = new TreeSet<>((a, b) -> b - a);  //同样是一个Comparator
        set6.add(1);
        set6.add(3);
        set6.add(2);
        System.out.println(set6);

//        Map映射
//        通过保存键值对的形式来存储映射关系，就可以轻松地通过键找到对应的映射值
//        6.Map并不是Collection体系下的接口，而是单独的一个体系
//        7.使用最常见的HashMap，它的底层采用哈希表实现
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "小明");   //使用put方法添加键值对，返回值我们会在后面讨论
        map.put(2, "小红");
        map.put(2, "小绿");   //这里的键跟之前的是一样的，这样会导致将之前的键值对覆盖掉
        System.out.println(map.get(2)); //使用get方法根据键获取对应的值
//        8.Map中无法添加相同的键，同样的键只能存在一个，即使值不同。如果出现键相同的情况，那么会覆盖掉之前的
//        防止意外将之前的键值对覆盖掉
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "小明");
        map1.putIfAbsent(1, "小红");   //Java8新增操作，只有在不存在相同键的键值对时才会存放
        System.out.println(map1.get(1));
//        获取一个不存在的映射时，默认会返回null作为结果
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(1, "小明");   //Map中只有键为1的映射
        System.out.println(map2.get(3));  //此时获取键为3的值，那肯定是没有的，所以说返回null
//        为这种情况添加一个预备方案，当Map中不存在时，可以返回一个备选的返回值
        System.out.println(map2.getOrDefault(3, "备胎"));   //Java8新增操作，当不存在对应的键值对时，返回备选方案
//        9.因为HashMap底层采用哈希表实现，所以不维护顺序，我们在获取所有键和所有值时，可能会是乱序的
        Map<String , String> map3 = new HashMap<>();
        map3.put("0", "十七张");
        map3.put("+", "牌");
        map3.put("P", "你能秒我");
        System.out.println(map3);
        System.out.println(map3.keySet());
        System.out.println(map3.values());
//        如果需要维护顺序，我们同样可以使用LinkedHashMap，它的内部对插入顺序进行了维护
        Map<String , String> map4 = new LinkedHashMap<>();
        map4.put("0", "十七张");
        map4.put("+", "牌");
        map4.put("P", "你能秒我");
        System.out.println(map4);
        System.out.println(map4.keySet());
        System.out.println(map4.values());
//        10.TreeMape，它的内部直接维护了一个红黑树（没有使用哈希表）因为它会将我们插入的结点按照规则进行排序，
//        所以说直接采用红黑树会更好，我们在创建时，直接给予一个比较规则即可，跟之前的TreeSet是一样的
        Map<Integer , String> map5 = new TreeMap<>((a, b) -> b - a);
        map5.put(0, "单走");
        map5.put(1, "一个六");
        map5.put(3, "**");
        System.out.println(map5);

//        Map中定义的方法，compute方法
        Map<Integer, String> map6 = new HashMap<>();
        map6.put(1, "A");
        map6.put(2, "B");
        map6.compute(1, (k, v) -> v+"M");   //compute会将指定Key的值进行重新计算，若Key不存在，v会返回null
        map6.computeIfPresent(1, (k, v) -> v+"M");   //当Key存在时存在则计算并赋予新的值
        System.out.println(map6);
//        也可以使用computeIfAbsent，当不存在Key时，计算并将键值对放入Map中
        Map<Integer, String> map7 = new HashMap<>();
        map7.put(1, "A");
        map7.put(2, "B");
        map7.computeIfAbsent(1, (k) -> "M");   //若不存在则计算并插入新的值
        System.out.println(map7);
//        replace方法可以快速替换某个映射的值
        Map<Integer , String> map8 = new HashMap<>();
        map8.put(0, "单走");
        map8.replace(0, ">>>");   //直接替换为新的
        System.out.println(map8);
//        也可以精准匹配
        Map<Integer , String> map9 = new HashMap<>();
        map9.put(0, "单走");
        map9.replace(0, "巴卡", "玛卡");   //只有键和值都匹配时，才进行替换
        System.out.println(map9);
//        包括remove方法，也支持键值同时匹配
        Map<Integer , String> map10 = new HashMap<>();
        map10.put(0, "单走");
        map10.remove(0, "单走");  //只有同时匹配时才移除
        System.out.println(map10);

//        Stream流
        List<String> list7 = new ArrayList<>();
        list7.add("A");
        list7.add("B");
        list7.add("C");
        //移除为B的元素
        Iterator<String> iterator2 = list7.iterator();
        while (iterator2.hasNext()){
            if(iterator2.next().equals("B")) iterator2.remove();
        }
        //Stream操作
        list7 = list7     //链式调用
                .stream()    //获取流
                .filter(e -> !e.equals("B"))   //只允许所有不是B的元素通过流水线
                .collect(Collectors.toList());   //将流水线中的元素重新收集起来，变回List
        System.out.println(list7);

        List<Integer> list8 = new ArrayList<>();
        list8.add(1);
        list8.add(2);
        list8.add(3);
        list8.add(3);
        list8 = list8
                .stream()
                .distinct()   //去重（使用equals判断）
                .sorted((a, b) -> b - a)    //进行倒序排列
                .map(e -> e+1)    //每个元素都要执行+1操作
                .limit(2)    //只放行前两个元素
                .collect(Collectors.toList());
        System.out.println(list8);

        Random random = new Random();  //没想到吧，Random支持直接生成随机数的流
        random
                .ints(-100, 100)   //生成-100~100之间的，随机int型数字（本质上是一个IntStream）
                .limit(10)   //只获取前10个数字（这是一个无限制的流，如果不加以限制，将会无限进行下去！）
                .filter(i -> i < 0)   //只保留小于0的数字
                .sorted()    //默认从小到大排序
                .forEach(System.out::println);   //依次打印

//        可以通过flat来对整个流进行进一步细分
        List<String> list9 = new ArrayList<>();
        list9.add("A,B");
        list9.add("C,D");
        list9.add("E,F");   //我们想让每一个元素通过,进行分割，变成独立的6个元素
        list9 = list9
                .stream()    //生成流
                .flatMap(e -> Arrays.stream(e.split(",")))    //分割字符串并生成新的流
                .collect(Collectors.toList());   //汇成新的List
        System.out.println(list9);   //得到结果

//        可以只通过Stream来完成所有数字的和，使用reduce方法
        List<Integer> list10 = new ArrayList<>();
        list10.add(1);
        list10.add(2);
        list10.add(3);
        int sum = list10
                .stream()
                .reduce((a, b) -> a + b)   //计算规则为：a是上一次计算的值，b是当前要计算的参数，这里是求和
                .get();    //我们发现得到的是一个Optional类实例，通过get方法返回得到的值
        System.out.println(sum);

//        Collections工具类

//        List中的最大值和最小值：
        List<Integer> list11 = new ArrayList<>(Arrays.asList(2, 3, 8, 9, 10, 13));
        System.out.println(Collections.max(list11));
        System.out.println(Collections.min(list11));
//        我们也可以对集合的元素进行快速填充，注意这个填充是对集合中已有的元素进行覆盖
        List<Integer> list12 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Collections.fill(list12, 6);
        System.out.println(list12);
//        我们也可以寻找子集合的位置
        List<Integer> list13 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(Collections.indexOfSubList(list13, Arrays.asList(4, 5)));

    }
}
