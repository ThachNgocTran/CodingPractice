package com.company;

import java.lang.reflect.Array;
import java.util.Scanner;

public class MyMain {

    public static void main(String[] args) {
        try{
            MyTest.testReadWriteFiles();

            int k = 100;

        } catch (RuntimeException ex){
            System.out.println(String.format("Unexpected error: [%s]", ex.toString()));
        } catch (Exception ex){ // Catch all!
            System.out.println(String.format("Catch-all error: [%s]", ex.toString()));
        }
    }
}
