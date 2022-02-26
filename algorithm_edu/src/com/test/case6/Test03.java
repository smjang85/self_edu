package com.test.case6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Test03 {
    
    
    public static int solution(int[] ages) {
        int[] count = {0,1,2,3,4,5,6,7,8,9};
        HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();
        for(int i=0; i < ages.length; i++) {
            data = count(ages[i],data);
        }
        float sum = data.getOrDefault(6, 0) + data.getOrDefault(9, 0); 
        data.put(6, Math.round(sum/2));
        data.put(9, Math.round(sum/2));
        
        Set set = data.keySet();
        Iterator iterator = set.iterator();
        int max = Integer.MIN_VALUE;
        while (iterator.hasNext()) {
            Integer key = (Integer)iterator.next();
            if(key != 6) {
                int val = data.get(key);
                max = Math.max(max, val);    
            }
        }
        return max;
    }
    
    public static HashMap<Integer,Integer> count(int age, HashMap<Integer,Integer> data) {
        String str = String.valueOf(age);
        for(int i = 0; i < str.length(); i++) {
            Integer s = Integer.parseInt(String.valueOf(str.charAt(i)));
            data.put(s, data.getOrDefault(s, 0) + 1);    
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        int[] v= {23,61,46};
        System.out.println(solution(v));
    }
}
