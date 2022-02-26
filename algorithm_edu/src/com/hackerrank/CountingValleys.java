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

public class CountingValleys {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here
    	int countValleys = 0;
    	int standardDepth = 0;
    	int currentDepth = 0;
    	
    	boolean startValley = false;
    	for(int i = 0 ; i < steps; i++) {
    		if("D".equals(String.valueOf(path.charAt(i)))) {
    			currentDepth = currentDepth - 1;
    		}else {
    			currentDepth = currentDepth + 1;
    		}
    		
    		if(currentDepth == (standardDepth-1)) {
    			startValley = true;
    		}else if(currentDepth == (standardDepth) && startValley == true ) {
    			countValleys++;
    			startValley = false;
    		}
    	}
    	return countValleys;
    }

    public static void main(String[] args) throws IOException {
/*        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
*/
        //int steps = Integer.parseInt(bufferedReader.readLine().trim());
        int steps = 16;

        //String path = bufferedReader.readLine();
        String path = "UDDDUDUUUDDDUDUU";

        int result = countingValleys(steps, path);
        System.out.println("result : " + result);
/*        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
