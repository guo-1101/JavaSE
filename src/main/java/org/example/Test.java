package org.example;

public class Test {
//    单例模式就是全局只能使用这一个对象，不能创建更多的对象
    private static Test instance;

    private Test(){}

    public static Test getInstance() {
        if(instance == null)
            instance = new Test();
        return instance;
    }
}
