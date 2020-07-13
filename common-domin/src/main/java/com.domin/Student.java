package com.domin;

import lombok.Data;

@Data
public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public String toString() {
        return "name:"+name+",age:"+age;
    }


}
