package com.test.case1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
3.
Problem Statement
You have several sticks of different lengths, and a stick case of a fixed length.
We want to find 2 sticks that just fit in the case.
 
Input
[L1] [L2] ... [LN]
[target]
The first line of input contains a list of integers separated by a whitespace. This list represents the lengths of the sticks.
The second line of input contains an integer target. This integer represents the length of the case.

Output
Output a pair of lengths whose sum is equal to target.  

[La] [Lb]
Output should be ordered in ascending order. (e.g. "1 2" is acceptable. "2 1" is not)
If you find 2 or more pairs, output the pair which contains the stick of the shortest length. (e.g. If the target is 5, and you find both "1 4" and "2 3", output "1 4")
In case there is no such pairs, output a single -1


Input Example
1 2 3 4 5
6
Output Example
1 5
 */
public class Sticks
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int boxSize = Integer.parseInt(br.readLine());
        
        String[] stickArr = input.split(" ");
        String result = "-1"; 
        for(int i = 0; i < stickArr.length; i++) {
        	if(!"-1".equals(result)) {
        		break;
        	}
        	
    		int firstFair = Integer.parseInt(stickArr[i]);
        	for(int j = 0 ; j < stickArr.length; j++) {
        		if(i != j) {
        			int secondFair = Integer.parseInt(stickArr[j]);
        			if(boxSize == (firstFair+ secondFair)) {
        				result = firstFair + " " + secondFair;
        				break;
        			}
        		}
        	}	
        }
        System.out.println(result);
    }
}
