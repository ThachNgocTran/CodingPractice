package com.company;

/**
 * Created on 26/Jul/2017.
 */
public class ClassWithSynchronization {

    private String someString;
    private static String someStringStatic;

    /*
    General principles:
    + If a method/block code isn't marked with "synchronized", it can run AT WILL.
    + When synchronizing on variables, actually we lock on the object referred/pointed by the variable.
     */

    /*
    When a thread first enters this method, it blocks at class-level, meaning every other STATIC method on THIS class is INACCESSIBLE.
     */
    public static synchronized void doSomethingStatic(){

    }

    /*
    When a thread first enters this method, it blocks at instance-level, meaning every other NON-STATIC method on THIS object is INACCESSIBLE.
     */
    public synchronized void doSomethingInstance(){

    }

    public static void doItForMeStatic(){
        /*
        When a thread first enters this block, it blocks at variable-level, meaning that no other thread can lock the SAME variable regardless of places in this class.
         */
        synchronized (someStringStatic){

        }
    }

    public void doItForMe(){

        /*
        When a thread first enters this block, it blocks at variable-level, meaning that no other thread can lock the SAME variable regardless of places in this class.
         */
        synchronized (someString){

        }
    }
}
