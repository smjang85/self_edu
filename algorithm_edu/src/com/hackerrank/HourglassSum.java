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

public class HourglassSum {

    // Complete the hourglassSum function below.
    public static int hourglassSum(int[][] arr) {
    	//int[][] result = new int[4][4];
    	
    	int x = 0;
    	int y = 0;
    	int resCnt = Integer.MIN_VALUE;
    	for(int i = 0; i < arr.length; i++) {
    		for(int j = 0; j <arr[i].length; j++) {
    			if( x < 4 && y < 4) {
        			int cnt = arr[i][j] + arr[i][j+1] + arr[i][j+2];
        			cnt += arr[i+1][j+1];
        			cnt += arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
        			//result[x][y] = cnt;
        			if(cnt > resCnt) {
        				resCnt = cnt;
        			}
        			y++;
    			}
    		}
    		y = 0;
    		x++;
    	}
    	
/*    	for(int i = 0 ; i < result.length; i++) {
    		for(int j = 0; j < result[i].length; j++) {
    			System.out.print(result[i][j] + " ");
    		}
    		System.out.println("");
    	}
*/    	return resCnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = {{-9,-9,-9, 1,1,1},
        			   { 0,-9, 0, 4,3,2},
        			   {-9,-9,-9, 1,2,3},
        			   { 0, 0, 8, 6,6,0},
        			   { 0, 0, 0,-2,0,0},
        			   { 0, 0, 1, 2,4,0},
        };

/*        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }*/

        int result = hourglassSum(arr);
        System.out.println("result:" + result);
      /*  bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}