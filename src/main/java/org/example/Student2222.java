package org.example;

public class Student2222 {
//    private String status;   //状态，可以是跑步、学习、睡觉这三个之中的其中一种
//    public String getStatus() {
//        return status;
//    }
//    public void setStatus(String status) {
//        this.status = status;
//    }

    private Status2222 status;   //类型变成刚刚定义的枚举类
    public Status2222 getStatus() {
        return status;
    }
    public void setStatus(Status2222 status) {
        this.status = status;
    }
}
