package com.lambda.functions;

import java.util.function.DoubleToIntFunction;

public class FunctionTest {
    public static void main(String[] args) {
        //testDoubleToIntFunction();
    }

    private static void testDoubleToIntFunction() {
        DoubleToIntFunction function = (value)->{
            String a = value+"";
            Integer i =  Integer.parseInt(a);
            return i;
        };
        Integer integer = function.applyAsInt(13);
        System.out.println(integer);
    }

}
