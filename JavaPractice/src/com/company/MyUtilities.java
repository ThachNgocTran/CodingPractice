package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by iRobot on 01/Jun/2016.
 */
public class MyUtilities {

    public static void quickSort(int[] inArr, int start, int end){

        if (inArr == null || inArr.length == 0){
            return;
        }

        int pivot = inArr[(start + end) / 2];
        int i = start;
        int j = end;

        while(i <= j){
            while(inArr[i] < pivot){
                i++;
            }
            while(inArr[j] > pivot){
                j--;
            }
            if (i <= j){
                int temp = inArr[i];
                inArr[i] = inArr[j];
                inArr[j] = temp;

                i++;
                j--;
            }
        }

        if (start < j){
            quickSort(inArr, start, j);
        }

        if (i < end){
            quickSort(inArr, i, end);
        }
    }

    public static Boolean checkIfSorted(int[] inArr) throws MyBusinessException{
        boolean result = true;

        if (inArr == null || inArr.length == 0)
            throw new MyBusinessException("Input array is null", -1);

        for(int i = 0; i < inArr.length - 1; i++){
            if (inArr[i] > inArr[i+1]){
                result = false;
                break;
            }
        }

        return result;
    }

    public static int binarySearch(int[] inArr, int key) throws MyBusinessException {
        int position = -1;

        if (inArr == null || inArr.length == 0)
            throw new MyBusinessException("Input array is null", -1);

        if (checkIfSorted(inArr) == false)
            throw new MyBusinessException("Array not sorted", -1);

        int start = 0;
        int end = inArr.length - 1;

        while(start <= end){
            int middle = (start+end)/2;
            if (inArr[middle] == key){
                position = middle;
                break;
            } else if (inArr[middle] < key) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return position;
    }

    public static boolean checkUniqueCharacters(String str){
        boolean result = true;

        // Suppose that the string is of ASCII
        boolean[] mapChars = new boolean[256];
        Arrays.fill(mapChars, false);

        for(int i = 0; i < str.length(); i++){
            int asciicode = (int)str.charAt(i);
            if (mapChars[asciicode]){
                result = false;
                break;
            } else {
                mapChars[asciicode] = true;
            }
        }

        return result;
    }

    public static String reverseString(String inStr){
        if (inStr == null || inStr.length() == 0)
            throw new IllegalArgumentException("Input string is invalid");

        StringBuilder strBuilder = new StringBuilder();

        for(int i = inStr.length() - 1; i >= 0; i--){
            strBuilder.append(inStr.charAt(i));
        }

        return strBuilder.toString();
    }

    public static String removeDuplicates(String inStr){
        StringBuilder strBuilder = new StringBuilder();

        for(int i = 0; i < inStr.length(); i++){
            char currChar = inStr.charAt(i);
            boolean already = false;
            for(int j = 0; j < i; j++){
                if (inStr.charAt(j) == currChar){
                    already = true;
                    break;
                }
            }
            if (!already){
                strBuilder.append(currChar);
            }
        }

        return strBuilder.toString();
    }

    public static boolean twoStringAnagram(String str1, String str2){
        boolean result = false;
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0){
            throw new IllegalArgumentException("Inputs are invalid");
        }

        if (str1.length() != str2.length()){
            result = false;
        }
        else{
            HashMap<Character, Integer> hm1 = new HashMap<>();
            HashMap<Character, Integer> hm2 = new HashMap<>();

            for(int i = 0; i < str1.length(); i++){
                char currChar = str1.charAt(i);
                if (!hm1.containsKey(currChar)){
                    hm1.put(currChar, 1);
                }
                else{
                    hm1.put(currChar, hm1.get(currChar)+1);
                }
            }

            for(int i = 0; i < str2.length(); i++){
                char currChar = str2.charAt(i);
                if (!hm2.containsKey(currChar)){
                    hm2.put(currChar, 1);
                }
                else{
                    hm2.put(currChar, hm2.get(currChar)+1);
                }
            }

            result = (hm1.equals(hm2));
        }

        return result;
    }

    public static String replaceAllSpaces(String strIn){
        StringBuilder strBuilder = new StringBuilder();

        if (strIn == null || strIn.length() == 0)
            throw new IllegalArgumentException("Input is null");

        for(int i = 0; i < strIn.length(); i++){
            char currChar = strIn.charAt(i);
            if ((int)currChar == 32){
                strBuilder.append("%20");
            } else {
                strBuilder.append(currChar);
            }
        }

        return strBuilder.toString();
    }

    public static boolean checkIfRotatedString(String str1, String str2){
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0){
            throw new IllegalArgumentException("Inputs are invalid");
        }

        boolean result = true;

        String strTemp = str1 + str1;
        if (strTemp.indexOf(str2) == -1) // isSubstring()
            result = false;

        return result;
    }

    /*
    Fibonacci with recursion
     */
    public static int calculateFibonacci(int inNumber){
        if (inNumber <= 0)
            throw new IllegalArgumentException("Input is invalid");

        if (inNumber == 1 || inNumber == 2)
            return 1;

        return calculateFibonacci(inNumber-1) + calculateFibonacci(inNumber - 2);
    }

    /*
    Fibonacci without recursion
     */
    public static int calculateFibonacci_nonRecursive(int intNumber){
        if (intNumber <= 0)
            throw new IllegalArgumentException("Input is invalid");

        int result = 0;
        if (intNumber == 1 || intNumber == 2){
            result = 1;
        }

        int preceding_1 = 1;
        int preceding_2 = 1;
        int curr = 3;

        while(curr <= intNumber){
            int newFibo = preceding_1 + preceding_2;
            preceding_1 = preceding_2;
            preceding_2 = newFibo;
            curr++;
        }
        result = preceding_2;
        return result;
    }

    /*
    String permutation with recursion.
    For example: "abc" ==> 3! = 6 ways to permute: abc, acb, bac, cab, bca, cba
     */
    public static ArrayList<String> permutateString(String inStr){
        ArrayList<String> permStrs = new ArrayList<>();

        if (inStr == null || inStr.length() == 0)
            throw new IllegalArgumentException("Input is invalid");

        // stopping condition for recursion
        if (inStr.length() == 2){
            String first = inStr;
            String second = String.format("%c%c", inStr.charAt(1), inStr.charAt(0));

            permStrs.add(first);
            permStrs.add(second);
        } else if (inStr.length() >= 3) {
            String firstChar = String.format("%c", inStr.charAt(0));
            String theRemaining = inStr.substring(1);

            ArrayList<String> tempArray = permutateString(theRemaining);
            for(int i = 0; i < tempArray.size(); i++){
                String currStr = tempArray.get(i);

                for(int j = 0; j <= currStr.length(); j++){
                    String permuted = currStr.substring(0, j) + firstChar + currStr.substring(j); // No OutOfBound!

                    permStrs.add(permuted);
                }
            }
        } else {    // < 2
            // impossible!
            throw new RuntimeException("Wrong logic");
        }

        return permStrs;
    }

    public static boolean checkUniqueElementsInList(ArrayList<String> arrList){
        if (arrList == null || arrList.size() == 0)
            throw new IllegalArgumentException("Input is invalid");

        boolean result = true;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < arrList.size(); i++){
            if (hm.containsKey(arrList.get(i))){
                result = false;
                break;
            } else {
                hm.put(arrList.get(i), 1);
            }
        }

        return result;
    }

    public static int[] mergeSortedArray(int[] firstArray, int[] secondArray){
        if (firstArray == null || firstArray.length == 0 || secondArray == null || secondArray.length == 0){
            throw new IllegalArgumentException("Inputs are invalid");
        }

        int[] result = new int[firstArray.length + secondArray.length];
        int firstRunner = 0;
        int secondRunner = 0;
        int currRun = 0;

        while(firstRunner < firstArray.length && secondRunner < secondArray.length){
            if (firstArray[firstRunner] < secondArray[secondRunner]){
                result[currRun] = firstArray[firstRunner];
                firstRunner++;
            } else if (firstArray[firstRunner] > secondArray[secondRunner]){
                result[currRun] = secondArray[secondRunner];
                secondRunner++;
            } else {
                result[currRun] = firstArray[firstRunner];
                currRun++;
                result[currRun] = secondArray[secondRunner];
                firstRunner++;
                secondRunner++;
            }
            currRun++;
        }

        // process the rest (if any)
        if (firstRunner < firstArray.length){
            while(firstRunner < firstArray.length){
                result[currRun] = firstArray[firstRunner];
                currRun++;
                firstRunner++;
            }
        }
        if (secondRunner < secondArray.length){
            while(secondRunner < secondArray.length){
                result[currRun] = secondArray[secondRunner];
                currRun++;
                secondRunner++;
            }
        }

        // just double check
        if (currRun != result.length)
            throw new RuntimeException("Wrong logic");

        return result;
    }

    /*
    https://jsoup.org/
    JSoup is an Java HTML Parser.

    Selector syntax: https://jsoup.org/apidocs/org/jsoup/select/Selector.html
     */

    public static String extractTextFromHtml(String url, String path) throws IOException, MyBusinessException {
        String extractedTxt = "";

        // Easiest way to get a user agent string for a browser: just visit http://www.whoishostingthis.com/tools/user-agent/
        String USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36";
        int TIME_OUT = 10000;

        if (url == null || url.length() == 0 || path == null || path.length() == 0)
            throw new IllegalArgumentException("Inputs are invalid");

        Document doc = Jsoup.connect(url).userAgent(USER_AGENT).timeout(TIME_OUT).get();
        Element ele = doc.select(path).first();

        if (ele == null)
            throw new MyBusinessException(String.format("Element not found: %s", path), 1);

        extractedTxt = ele.text();

        return extractedTxt;
    }

    /*
    http://stackoverflow.com/questions/37324372/jsoup-parsing-parsing-multiple-links-simultaneously
    A very 'convenient' way to quickly parallelize processing for each item in the list.
     */
    public static void parallelPrint(int numParallel){
        if (numParallel <= 0)
            throw new IllegalArgumentException("Input is invalid");

        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < numParallel; i++){
            arrList.add(i);
        }

        /*
        Each time this code snippet runs, the output is different! Thanks to parallelism.
         */
        arrList.parallelStream().forEach(link -> {
            try{
                System.out.println(String.format("Processing: %d", link));
            }
            catch (Exception ex){
                System.out.println(ex.toString());
            }
        });
    }

    /*
    Java Concurrency:
    http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
    http://stackoverflow.com/questions/12759676/java-jsoup-using-threads-not-working

     */


}
