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

public class RepeatedString {

    // Complete the repeatedString function below.
    public static long repeatedString(String s, long n) {
    	long countA = 0;
    	for(int i = 0; i < s.length(); i ++) {
    		if("a".equals(String.valueOf(s.charAt(i)))) {
    			countA++;
    		}
    	}
    	long count = (n / s.length()) * countA;
    	
    	long countB = 0;
    	for(int i = 0; i < (n % s.length()); i++) {
    		if("a".equals(String.valueOf(s.charAt(i)))) {
    			countB++;
    		}
    	}
    	count = count + countB;
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String s = scanner.nextLine();
    	String s = "a";
        //long n = scanner.nextLong();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    	Long n = new Long(1000000);
        long result = repeatedString(s, n);
        System.out.println("result :" + result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}
