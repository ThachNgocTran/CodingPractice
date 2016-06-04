package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iRobot on 01/Jun/2016.
 */
public class MyTest {

    public static void testQuickSort(){
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};

        MyUtilities.quickSort(input, 0, input.length-1);

        for(int i = 0; i < input.length; i++){
            System.out.printf("%d ", input[i]);
        }

        System.out.println();

        try{
            System.out.printf("%s", MyUtilities.checkIfSorted(input) == true ? "Sorted" : "Not Sorted");
        }
        catch(MyBusinessException ex){
            System.out.println(ex.toString());
        }

        try{
            System.out.printf("Searching for %d: Pos = %d\n", 100, MyUtilities.binarySearch(input, 100));
            System.out.printf("Searching for %d: Pos = %d\n", 45, MyUtilities.binarySearch(input, 45));
            System.out.printf("Searching for %d: Pos = %d\n", 99, MyUtilities.binarySearch(input, 99));
        }
        catch(MyBusinessException ex){
            System.out.println(ex.toString());
        }
    }

    /*
    1.1 Page 88/292 (Cracking the coding interview)
    Implement an algorithm to determine if a string has all unique characters What if
you can not use additional data structures?
     */

    public static void testUniqueCharacters(){
        String str1 = "wefoijhhg38946t239ru02bfewf";
        String str2 = "qwertyuiopasdfghjklzxcvbnm1234567890";
        System.out.println(String.format("str1: %s => %b", str1, MyUtilities.checkUniqueCharacters(str1)));
        System.out.println(String.format("str2: %s => %b", str2, MyUtilities.checkUniqueCharacters(str2)));
    }

    /*
    1 2 Write code to reverse a C-Style String (C-String means that “abcd” is represented as
five characters, including the null character )
     */

    public static void testReverseString(){
        String str1 = "1234567890";
        String str2 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(String.format("str1: %s => %s", str1, MyUtilities.reverseString(str1)));
        System.out.println(String.format("str2: %s => %s", str2, MyUtilities.reverseString(str2)));
    }

    /*
    1 3 Design an algorithm and write code to remove the duplicate characters in a string
without using any additional buffer
    ==> without additional buffer ==> put in place like in C++
    ==> with additional buffer ==> use kind of hashmap
    ==> Otherwise, the diligent/natural approach: proceed character-by-character, then check back.
     */

    public static void testRemoveDuplicates(){
        String str1 = "abcdefghijklmnopqrstuvwxyz";
        String str2 = "abcabdghjjkl";

        System.out.println(String.format("str1: %s => %s", str1, MyUtilities.removeDuplicates(str1)));
        System.out.println(String.format("str2: %s => %s", str2, MyUtilities.removeDuplicates(str2)));
    }

    /*
    1 4 Write a method to decide if two strings are anagrams or not
     */

    public static void testTwoStringAnagram(){
        String str1 = "abcdefghijklmnopqrstuvwxyz";
        String str2 = "qwertyuiopasdfghjklzxcvbnm";

        System.out.println(String.format("str1: %s\nstr2: %s\n==> %b", str1, str2, MyUtilities.twoStringAnagram(str1, str2)));
    }

    /*
    1 5 Write a method to replace all spaces in a string with ‘%20’
    Page 93/292
     */

    public static void testReplaceAllSpaces(){
        String str1 = "wefhej ef  wefhwef ";
        String str2 = " wefh23789349023rh";

        System.out.println(String.format("str1: [%s] => [%s]", str1, MyUtilities.replaceAllSpaces(str1)));
        System.out.println(String.format("str2: [%s] => [%s]", str2, MyUtilities.replaceAllSpaces(str2)));
    }

    /*
    1 6 Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees Can you do this in place?
    ==> Not doing
     */

    /*
    1 7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column is set to 0
    ==> Not doing
    Trick: make a second array to keep positions of 0s. Then start setting its row/column in the
    main matrix.
     */

    /*
    1 8 Assume you have a method isSubstring which checks if one word is a substring of
another Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
only one call to isSubstring (i e , “waterbottle” is a rotation of “erbottlewat”)
    Trick: concatenate s1 to itself, and then check with s2
     */

    public static void testIfRotationString(){
        String str1 = "apple";
        String str2 = "pleap";
        String str3 = "apple";
        String str4 = "ppale";

        System.out.println(String.format("str1: %s\nstr2: %s\n=> %b\n", str1, str2, MyUtilities.checkIfRotatedString(str1, str2)));
        System.out.println(String.format("str3: %s\nstr4: %s\n=> %b\n", str3, str4, MyUtilities.checkIfRotatedString(str3, str4)));
    }

    /* 2 1 Write code to remove duplicates from an unsorted linked list
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
    ==> Not doing
    ==> Use hashmap to detect duplicates.
    */

    /*
    How would you design a stack which, in addition to push and pop, also has a function
min which returns the minimum element? Push, pop and min should all operate in
O(1) time
    ==> Not doing
    ==> Trick: keep min whenever adding/removing an element so that when needed, have it immediately
     */

    /*
    8 1 Write a method to generate the nth Fibonacci number
     */
    // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811,
    public static void testCalculateFibonacci(){
        System.out.println(String.format("10th => %d (should be: 55)\n", MyUtilities.calculateFibonacci(10)));
        System.out.println(String.format("20th => %d (should be: 6765)\n", MyUtilities.calculateFibonacci(20)));

        System.out.println(String.format("Non Rec 10th => %d (should be: 55)\n", MyUtilities.calculateFibonacci_nonRecursive(10)));
        System.out.println(String.format("Non Rec 20th => %d (should be: 6765)\n", MyUtilities.calculateFibonacci_nonRecursive(20)));
    }

    /*
    8 4 Write a method to compute all permutations of a string
     */

    public static void testStringPermutation(){
        // FIRST TEST CASE
        String str1 = "abc";    // should be 3! = 6 permutations

        ArrayList<String> permutedStrs1 = MyUtilities.permutateString(str1);
        if (permutedStrs1 == null)
            throw new RuntimeException("Wrong logic");

        System.out.println(String.format("There are: [%d] permuted strings for [%s]", permutedStrs1.size(), str1));
        System.out.println(String.format("Unique elements? => %b", MyUtilities.checkUniqueElementsInList(permutedStrs1)));
        for(int i = 0; i < permutedStrs1.size(); i++){
            System.out.println(permutedStrs1.get(i));
        }

        // SECOND TEST CASE
        String str2 = "abcd";    // should be 4! = 24 permutations

        ArrayList<String> permutedStrs2 = MyUtilities.permutateString(str2);
        if (permutedStrs2 == null)
            throw new RuntimeException("Wrong logic");

        System.out.println(String.format("There are: [%d] permuted strings for [%s]", permutedStrs2.size(), str2));
        System.out.println(String.format("Unique elements? => %b", MyUtilities.checkUniqueElementsInList(permutedStrs2)));
        for(int i = 0; i < permutedStrs2.size(); i++){
            System.out.println(permutedStrs2.get(i));
        }

        // SECOND TEST CASE
        String str3 = "abcde";    // should be 5! = 120 permutations

        ArrayList<String> permutedStrs3 = MyUtilities.permutateString(str3);
        if (permutedStrs3 == null)
            throw new RuntimeException("Wrong logic");

        System.out.println(String.format("There are: [%d] permuted strings for [%s]", permutedStrs3.size(), str3));
        System.out.println(String.format("Unique elements? => %b", MyUtilities.checkUniqueElementsInList(permutedStrs3)));
        for(int i = 0; i < permutedStrs3.size(); i++){
            System.out.println(permutedStrs3.get(i));
        }
    }

    /*
    9 1 You are given two sorted arrays, A and B, and A has a large enough buffer at the end
to hold B Write a method to merge B into A in sorted order
    ==> One convenient approach is to attach the two arrays together, than sort.
    ==> Another naive, natural approach is to use "runners" as below.
     */

    public static void testMergeSortedArray(){
        // TEST CASE 1
        int[] arr1 = new int[]{1,3,5,7,9};
        int[] arr2 = new int[]{0,2,4,6,8,10};
        int[] res12 = MyUtilities.mergeSortedArray(arr1, arr2);
        // The quickest way to print an array.
        System.out.println(Arrays.toString(res12));

        // TEST CASE 2
        int[] arr3 = new int[]{1,3,5,7,29,30,35,74};
        int[] arr4 = new int[]{0,2,4,6,25,29};
        int[] res34 = MyUtilities.mergeSortedArray(arr3, arr4);
        System.out.println(Arrays.toString(res34));
    }

    /*
    Read!!!
    Solutions to Chapter 11 | System Design and Memory Limits
    Solutions to Chapter 12 | Testing
    Solutions to Chapter 14 | Java
    Solutions to Chapter 15 | Databases
    Solutions to Chapter 18 | Threads and Locks
     */

    /*
    https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html
    http://www.drdobbs.com/jvm/java-se-7-new-file-io/231600403

    Reason to use NIO: https://dzone.com/articles/java-nio-vs-io
    NIO is non-blocking (Buffer oriented). Suitable for P2P (A few threads manage many connections).
    IO is blocking (Stream oriented). Otherwise.

    But the point of java.nio.file.Files is for "easy and quick" programming!!!
    http://stackoverflow.com/questions/17084657/most-robust-way-of-reading-a-file-or-stream-using-java-to-prevent-dos-attacks/17165330#17165330
     */
    public static void testReadWriteFiles() throws IOException {

        String strFilePathRead = "testFile.txt";
        String strFilePathWrite = "testFileWrite.txt";

        ///////// READ
        // Read all bytes at once (not too large file).
        byte[] byteArray = Files.readAllBytes(Paths.get(strFilePathRead));

        // Read all lines at once (not too large file).
        List<String> lineArray = Files.readAllLines(Paths.get(strFilePathRead), StandardCharsets.UTF_8);

        // Read using buffer to read, good for large files
        BufferedReader reader = Files.newBufferedReader(Paths.get(strFilePathRead), StandardCharsets.UTF_8);
        String line = null;
        while((line = reader.readLine()) != null){
            int len = line.length();
        }
        reader.close(); // remember to close

        ///////// WRITE
        // Write all bytes at once
        Files.write(Paths.get(strFilePathWrite), byteArray, StandardOpenOption.CREATE); // https://docs.oracle.com/javase/7/docs/api/java/nio/file/StandardOpenOption.html

        // Write all lines at once
        Files.write(Paths.get(strFilePathWrite), lineArray, StandardCharsets.UTF_8, StandardOpenOption.CREATE);

        // Write using buffer to write
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(strFilePathWrite), StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        writer.write("abc");
        writer.newLine();
        writer.append("xyz");
        writer.flush();  // if we finish writing data, it's time to flush it; otherwise, just write, write and let the system decide when to flush.
        writer.close(); // remember to close
    }
}
