package org.example;

public class Main5 {
    public static void main(String[] args) {

//        异常机制
//        异常的类型
//        我们的每一个异常也是一个类，他们都继承自Exception类！
//        异常类型本质依然类的对象，但是异常类型支持在程序运行出现问题时抛出（也就是上面出现的红色报错）也可以提前声明

//        异常的第一种类型是运行时异常，在编译阶段无法感知代码是否会出现问题，
//        只有在运行的时候才知道会不会出错（正常情况下是不会出错的），这样的异常称为运行时异常，
//        异常也是由类定义的，所有的运行时异常都继承自RuntimeException。

//        异常的另一种类型是编译时异常，编译时异常明确指出可能会出现的异常，
//        在编译阶段就需要进行处理（捕获异常）必须要考虑到出现异常的情况，如果不进行处理，将无法通过编译！
//        默认继承自Exception类的异常都是编译时异常。

//        抛出运行时异常
//        test(1, 0);
//        异常的抛出同样需要创建一个异常对象出来，我们抛出异常实际上就是将这个异常对象抛出，
//        异常对象携带了我们抛出异常时的一些信息，比如是因为什么原因导致的异常，在RuntimeException的构造方法中我们可以写入原因。

//        抛出编译时异常
//        注意，如果我们在方法中抛出了一个非运行时异常，那么必须告知函数的调用方我们会抛出某个异常，
//        函数调用方必须要对抛出的这个异常进行对应的处理才可以
//        try {
//            test();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//        异常的处理
//        当程序没有按照我们理想的样子运行而出现异常时（默认会交给JVM来处理，JVM发现任何异常都会立即终止程序运行，并在控制台打印栈追踪信息）
//        现在我们希望能够自己处理出现的问题，让程序继续运行下去，就需要对异常进行捕获

//        我们可以将代码编写到try语句块中，只要是在这个范围内发生的异常，都可以被捕获，使用catch关键字对指定的异常进行捕获，
//        这里我们捕获的是NullPointerException空指针异常
        try {    //使用try-catch语句进行异常捕获
            Object object = null;
            object.toString();
        } catch (NullPointerException e){   //因为异常本身也是一个对象，catch中实际上就是用一个局部变量去接收异常
//            我们可以在catch语句块中对捕获到的异常进行处理
            e.printStackTrace();   //打印栈追踪信息
            System.out.println("异常错误信息："+e.getMessage());   //获取异常的错误信息
        }
        System.out.println("程序继续正常运行！");

//        注意，catch中捕获的类型只能是Throwable的子类，也就是说要么是抛出的异常，要么是错误，不能是其他的任何类型。

//        如果我们要捕获的异常，是某个异常的父类，那么当发生这个异常时，同样可以捕获到
        try {
            int[] arr = new int[1];
            arr[1] = 100;    //这里发生的是数组越界异常，它是运行时异常的子类
        } catch (RuntimeException e){  //使用运行时异常同样可以捕获到
            System.out.println("捕获到异常");
        }

//        当代码可能出现多种类型的异常时，我们希望能够分不同情况处理不同类型的异常，就可以使用多重异常捕获
        try {
            //....
        } catch (NullPointerException e) {
        } catch (IndexOutOfBoundsException e){
        } catch (RuntimeException e){
        }
//        但是要注意一下顺序
//        try {
//            //....
//        } catch (RuntimeException e){  //父类型在前，会将子类的也捕获
//        } catch (NullPointerException e) {   //永远都不会被捕获
//        } catch (IndexOutOfBoundsException e){   //永远都不会被捕获
//        }
//        只不过这样写好像有点丑，我们也可以简写为
        try {
            //....
        } catch (NullPointerException | IndexOutOfBoundsException e) {  //用|隔开每种类型即可
        }

//        最后，当我们希望，程序运行时，无论是否出现异常，都会在最后执行任务，可以交给finally语句块来处理
        try {
            //....
        }catch (Exception e){

        }finally {
            System.out.println("lbwnb");   //无论是否出现异常，都会在最后执行
        }

    }
    public static int test(int a, int b) {
        if(b == 0)
            throw new RuntimeException("被除数不能为0");  //使用throw关键字来抛出异常
        return a / b;
    }
    private static void test() throws Exception {    //使用throws关键字告知调用方此方法会抛出哪些异常，请调用方处理好
        throw new Exception("我是编译时异常！");
    }
}
