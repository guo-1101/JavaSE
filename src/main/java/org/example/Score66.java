package org.example;

public class Score66<T extends Number> {   //设定类型参数上界，必须是Number或是Number的子类
    private final String name;
    private final String id;
    private final T value;

    public Score66(String name, String id, T value) {
        this.name = name;
        this.id = id;
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
