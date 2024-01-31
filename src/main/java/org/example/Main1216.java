package org.example;

public record Main1216(String username, String password) {  //直接把字段写在括号中  支持实现接口，但是不支持继承，因为继承的坑位已经默认被占了
}
