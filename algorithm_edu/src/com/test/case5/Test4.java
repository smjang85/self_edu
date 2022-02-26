package com.test.case5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test4
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
