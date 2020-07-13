package com.lambda.parallel;

import com.domin.Student;

public class Service {
    public  Student s1(String a){
        Student student = new Student("niuniu1",1);
        try {
            System.out.println(Thread.currentThread().getName()+"  "+System.currentTimeMillis()+"------1----s----");
            System.out.println(Thread.currentThread());
            Thread.sleep(10000); //模仿处理
            System.out.println(Thread.currentThread().getName()+"  "+System.currentTimeMillis()+"------1----end----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return student;
    }

    public Student s2(){
         Student student = new Student();
        try {
            System.out.println(Thread.currentThread().getName()+"  "+System.currentTimeMillis()+"------2----s----");
            Thread.sleep(2000); //模仿处理
            student = new Student("niu2",1);
            System.out.println(Thread.currentThread().getName()+"  "+System.currentTimeMillis()+"------2----end----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return student;
    }
}
