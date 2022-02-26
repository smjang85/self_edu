package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        HashMap data = new HashMap();
        for(int i : ar) {
            if(data.containsKey(i)) {
            	data.put(i, (Integer)data.get(i) + 1);
            }else {
            	data.put(i, 1);
            }
        }
        int count = 0;
        Set set = data.keySet();

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
    	  int key = (Integer)iterator.next();
    	  int value = (Integer)data.get(key);
    	  int pairCnt = value/2;
    	  count += pairCnt;
    	}

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));*/

        int n = 9;
/*        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");*/

        int[] ar = {10,20,20,10,10,30,50,10,20};

/*        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }*/

        int result = sockMerchant(n, ar);
        System.out.println("result :" + result);
/*        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}