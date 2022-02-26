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

public class MinimumAbsoluteDifference {

	   // Complete the minimumAbsoluteDifference function below.
    public static int minimumAbsoluteDifference(int[] arr) {
    	int min = Integer.MAX_VALUE;
    	Arrays.sort(arr);
    	
    	for(int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i] + ",");
    	}
    	for(int i = 0; i < arr.length-1; i++) {
			min = Math.min(min, Math.abs(arr[i] - arr[i+1]));	
			System.out.println(min);
    	}
    	return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        minimumAbsoluteDifference(new int[]{-59 ,-36, -13, 1 ,-53 ,-92 ,-2 ,-96 ,-54 ,75});

        scanner.close();
    }
}