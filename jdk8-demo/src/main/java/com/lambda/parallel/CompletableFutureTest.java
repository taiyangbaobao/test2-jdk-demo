package com.lambda.parallel;

import com.domin.Student;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CompletableFuture<Student> future1 = CompletableFuture.supplyAsync(
                ()->{
                    Service s = new Service();
                    return s.s1("1");
                }
        );
        CompletableFuture<Student> future2 = CompletableFuture.supplyAsync( ()->{
            Service s = new Service();
            return s.s2();
        });

//        ((CompletableFuture<Student>) future1).thenAccept((student)->
//            System.out.println(Thread.currentThread().getName()+" 获取结果 "+System.currentTimeMillis()+"------2--------"+student)
//        );
//
//        ((CompletableFuture<Student>) future2).thenAccept((student)->
//                System.out.println(Thread.currentThread().getName()+" 获取结果 "+System.currentTimeMillis()+"------2--------"+student)
//        );

//        System.out.println(Thread.currentThread().getName()+" 获取结果 "+System.currentTimeMillis()+"------1--------"+future1.get());
//        System.out.println(Thread.currentThread().getName()+" 获取结果 "+System.currentTimeMillis()+"------2--------"+future2.get());


 /*       future1.thenAcceptBoth(future2,(student1,student2)->{
                    System.out.println(Thread.currentThread().getName()+" 获取结果 "+System.currentTimeMillis()+"------2--------"+student2);
                    System.out.println(Thread.currentThread().getName()+" 获取结果 "+System.currentTimeMillis()+"------1--------"+student1);
                }
        );
*/
        CompletableFuture<Student> future3 = CompletableFuture.supplyAsync( ()->{
            Service s = new Service();
            return s.s2();
        });

        future3.thenAcceptBoth(future1.thenAcceptBoth(future2,(student1,student2)->{
                    System.out.println(Thread.currentThread().getName()+" 获取结果 "+System.currentTimeMillis()+"------2--------"+student2);
                    System.out.println(Thread.currentThread().getName()+" 获取结果 "+System.currentTimeMillis()+"------1--------"+student1);
                }
        ),((student, aVoid) ->
            System.out.println(Thread.currentThread().getName()+" 获取结果 "+System.currentTimeMillis()+"------3--------"+student)
        ));

        System.out.println(Thread.currentThread().getName()+"  "+System.currentTimeMillis()+"-----get all------");
        Thread.sleep(15000l);
    }
}
