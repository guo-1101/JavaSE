import java.util.HashMap;
import java.util.Map;

public class Redis {

//    1.NoSQL概论
//    NoSQL全称是Not Only SQL（不仅仅是SQL）它是一种非关系型数据库，
//    远超传统关系型数据库的性能
//    非常易于扩展
//    数据模型更加灵活
//    高可用
//
//    NoSQL的优势，高并发海量数据的解决方案吗！
//
//    NoSQL数据库分为以下几种：
//    键值存储数据库：所有的数据都是以键值方式存储的，类似于我们之前学过的HashMap，使用起来非常简单方便，性能也非常高。
//    列存储数据库：这部分数据库通常是用来应对分布式存储的海量数据。键仍然存在，但是它们的特点是指向了多个列。
//    文档型数据库：它是以一种特定的文档格式存储数据，比如JSON格式，在处理网页等复杂数据时，文档型数据库比传统键值数据库的查询效率更高。
//    图形数据库：利用类似于图的数据结构存储数据，结合图相关算法实现高速访问。

//    2.Redis数据库
//
//    MySQL数据库，它是一种传统的关系型数据库，它的数据始终是存储在硬盘上的，
//    频繁使用的数据，比如微博热搜、双十一秒杀，这些数据不仅要求服务器需要提供更高的响应速度，而且还需要面对短时间内上百万甚至上千万次访问，
//    能够满足上述需求的只有内存，速度远高于磁盘IO读写性能。
//
//    Redis数据库，就是一个开源的键值存储数据库，所有的数据全部存放在内存中，它的性能大大高于磁盘IO，
//    并且它也可以支持数据持久化，他还支持横向扩展、主从复制等。

//    3.Redis安装和部署
//    Windows：双击redis-server.exe启动
//             redis-server.exe redis.windows.conf 加载配置文件启动命令
//             双击redis-cli.exe连接redis数据库
//             redis-cli.exe -h 127.0.0.1 别人连接你的redis命令

//    4.基本操作
//    Redis是一个键值数据库，可以像Map一样的操作方式，通过键值对向Redis数据库中添加数据（操作起来类似于向一个HashMap中存放数据）
//
//    在Redis下，数据库是由一个整数索引标识，而不是由一个数据库名称。 默认情况下，我们连接Redis数据库之后，会使用0号数据库，
//    我们可以通过Redis配置文件中的参数来修改数据库总数，默认为16个。
//    所有存入的数据默认会以字符串的形式保存
//
//    4.1通过select语句进行切换
//    select 序号
//    数据操作
//    4.2向Redis数据库中添加数据：
//    set <key> <value>
//    4.3一次性多个
//    mset <key> <value> ...
//    李子：mset a 1 b 2
//    4.4获取存入的值：
//    get <key>
//    4.5数据的过期时间设定
//    set <key> <value> EX 秒
//    set <key> <value> PX 毫秒
//    李子：set d 4 EX 10
//    4.6为其他的键值对设置过期时间：
//    expire <key> 秒
//    李子：expire a 10
//    4.7查询某个键值对的过期时间还剩多少
//    ttl <key>
//    毫秒显示
//    pttl <key>
//    4.8转换为永久
//    persist <key>
//    4.9删除数据，删除命令可以同时拼接多个键值一起删除。
//    del <key>...
//    4.10查看数据库中所有的键值
//    keys *
//    4.11查询某个键是否存在
//    exists <key>...
//    4.12随机拿一个键
//    randomkey
//    4.13将一个数据库中的内容移动到另一个数据库中
//    move <key> 数据库序号
//    4.14修改一个键为另一个键
//    rename <key> <新的名称>
//    4.15修改一个键为另一个键，检查新的名称是否已经存在
//    renamex <key> <新的名称>
//    4.16如果存放的数据是一个数字，我们还可以对其进行自增自减操作
//    等价于a = a + 1
//    incr <key>
//    等价于a = a + b
//    incrby <key> b
//    等价于a = a - 1
//    decr <key>
//    等价于a = a - b
//    decrby <key> b
//    4.17查看值的数据类型
//    type <key>

//    5.数据类型
//    Hash
//    这种类型本质上就是一个HashMap，也就是嵌套了一个HashMap罢了，在Java中就像这样：
//    Redis默认存String类似于这样：
    Map<String, String> hash = new HashMap<>();
//    Redis存Hash类型的数据类似于这样：
    Map<String, Map<String, String>> hashs = new HashMap<>();
//    它比较适合存储类这样的数据，由于值本身又是一个Map，因此我们可以在此Map中放入类的各种属性和值，以实现一个Hash数据类型存储一个类的数据。
//    5.1添加一个Hash类型的数据
//    hset <key> [<字段> <值>]...
//    李子：hset aa name 小明 age 18
//    5.2获取
//    hget <key> <字段>
//    一次性获取所有的字段和值
//    hgetall <key>
//    5.3判断某个字段是否存在
//    hexists <key> <字段>
//    5.4删除Hash中的某个字段
//    hdel <key> <字段>
//    5.5删除Hash
//    del <key>
//    在操作一个Hash时，实际上就是我们普通操作命令前面添加一个h，这样就能以同样的方式去操作Hash里面存放的键值对了。
//    5.6想要知道Hash中一共存了多少个键值对
//    hlen <key>
//    5.7一次性获取所有字段的值
//    hvals <key>
//    一次性获取所有字段的键
//    hkeys <key>
//    唯一需要注意的是，Hash中只能存放字符串值，不允许出现嵌套的的情况。

//    List
//    我们接着来看List类型，实际上这个猜都知道，它就是一个列表，而列表中存放一系列的字符串，它支持随机访问，支持双端操作，就像我们使用Java中的LinkedList一样。
//
//    我们可以直接向一个已存在或是不存在的List中添加数据，如果不存在，会自动创建：
//-- 向列表头部添加元素
//    lpush <key> <element>...
//            -- 向列表尾部添加元素
//    rpush <key> <element>...
//            -- 在指定元素前面/后面插入元素
//    linsert <key> before/after <指定元素> <element>
//    同样的，获取元素也非常简单：
//-- 根据下标获取元素
//    lindex <key> <下标>
//-- 获取并移除头部元素
//    lpop <key>
//-- 获取并移除尾部元素
//    rpop <key>
//-- 获取指定范围内的
//    lrange <key> start stop
//    注意下标可以使用负数来表示从后到前数的数字（Python：搁这儿抄呢是吧）:
//
//            -- 获取列表a中的全部元素
//    lrange a 0 -1
//    没想到吧，push和pop还能连着用呢：
//
//            -- 从前一个数组的最后取一个数出来放到另一个数组的头部，并返回元素
//    rpoplpush 当前数组 目标数组
//    它还支持阻塞操作，类似于生产者和消费者，比如我们想要等待列表中有了数据后再进行pop操作：
//
//            -- 如果列表中没有元素，那么就等待，如果指定时间（秒）内被添加了数据，那么就执行pop操作，如果超时就作废，支持同时等待多个列表，只要其中一个列表有元素了，那么就能执行
//    blpop <key>... timeout







}