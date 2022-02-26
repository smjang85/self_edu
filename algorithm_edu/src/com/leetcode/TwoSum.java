package com.leetcode;
public class TwoSum {
	

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
        	int targetOne = nums[i];
            for(int j = i + 1 ; j < nums.length ; j++){
            	int targetTwo = nums[j];
                int twoSum = targetOne + targetTwo;
                if(twoSum == target){
                	
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
		return result;
    }
    
	
	public static void main(String[] args) throws Exception {
		int[] nums= {3,3};
		int[] result = twoSum(nums,6);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}
