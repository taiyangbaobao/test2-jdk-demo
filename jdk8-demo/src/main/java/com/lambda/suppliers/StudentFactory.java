package com.lambda.suppliers;

import com.domin.Student;

import java.util.function.Supplier;

public class StudentFactory {
    public static void main(String[] args) {


        //使用supplier 的方法

    }

    public void test1(){
        Supplier<Student> supplier = Student::new;
        Supplier supplier1 = ()->new Student();
        Supplier supplier2 = ()->{return new Student();};
        Student student = supplier.get();
        student.setAge(2);
        student.setName("张三");
        System.out.println(student);
    }
}
