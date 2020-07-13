package com.lambda.streams;

import com.domin.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {
    static List<Student> list = new ArrayList();
    public static void main(String[] args) {
        List l = list.stream().filter(student -> student.getAge()>1).
                sorted((s1,s2)-> s1.getAge()-s1.getAge() )
                .map((Function<Student, Object>) Student::getName).collect(Collectors.toList());
        System.out.println(l);

        Map<String,Student> m = list.stream().filter(student -> student.getAge()>1)
                //.sorted((s1,s2)-> s1.getAge()-s1.getAge() )
                .collect(Collectors.toMap(Student::getName,student -> student));
        System.out.println(m);


       Map<Integer, List<Student>> map = list.stream()
                .collect(Collectors.groupingBy(Student::getAge));
        System.out.println(map);

        Map<Integer, List<Student>> map1 = list.stream()
                .collect(Collectors.groupingBy((student)->{
                    int age = student.getAge()+1;
                    student.setAge(age);
                    return age;
                  }
                ));
        System.out.println(map1);
    }


    static {
        list.add(new Student("张三",1));
        list.add(new Student("jeel",10));
        list.add(new Student("nie",23));
        list.add(new Student("wan",19));
        list.add(new Student("nuu",1));
    }
}
