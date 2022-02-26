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

public class MakeAnagram {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int sum = 0;
        int [] alphabet = new int[128];
        for (char c : a.toCharArray()){
            alphabet[c - 'a']++;
        }
        for (char c : b.toCharArray()){
            alphabet[c - 'a']--;
        }
        for (int i : alphabet){
            sum += Math.abs(i);
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       /* BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();*/

        int res = makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke");

        System.out.println("result : " + res);
     /*   bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}