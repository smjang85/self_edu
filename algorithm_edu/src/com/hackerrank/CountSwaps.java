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

public class CountSwaps {

    // Complete the countSwaps function below.
    public static void countSwaps(int[] a) {
    	int n = a.length;
    	int cnt = 0;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n - 1 ; j++) {
    			if(a[j] > a[j + 1]) {
    				int temp = a[j];
    				a[j] = a[j + 1];
    				a[j + 1] = temp;
    				cnt++;
    			}
    		}
    	}
    	
    	System.out.println("Array is sorted in "+cnt+" swaps."); 
    	System.out.println("First Element: " + a[0] );  
    	System.out.println("Last Element: " + a[a.length-1]);  
    }
    
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       /* int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }*/
    	int[] a = {3,2,1};
        countSwaps(a);

        //scanner.close();
    }
}