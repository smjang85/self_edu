package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TwoStrings {

    // Complete the twoStrings function below.
    public static String twoStrings(String s1, String s2) {
    	HashMap<String,String> data = new HashMap<String,String>();
    	for(int i = 0; i < s1.length(); i++) {
    		String str = String.valueOf(s1.charAt(i));
    		data.put(str, str);
    	}
    	
    	String result = "NO";
    	for(int i = 0; i < s2.length(); i++) {
    		String str = String.valueOf(s2.charAt(i));
    		if(data.containsKey(str)) {
    			return "YES";
    		}
    	}
    	
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int q = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = twoStrings("hi", "world");
        System.out.println("result : " + result);
        //bufferedWriter.close();

        scanner.close();
    }
}