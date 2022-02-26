package com.leetcode;
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] a, int[] b) {
    	int m = a.length;
    	int n = b.length;
    	if(m > n) { // m <= n, a < b
    		int[] temp = a; a = b; b = temp;
    		int tmp = m; m = n; n = tmp;
    	}
    	
    	int iMin = 0;
    	int iMax = m;
    	int halfLen = (m+n+1)/2;
    	while(iMin <= iMax) {
    		int i = (iMin + iMax) / 2; //1
    		int j = halfLen - i; // 4 -1=3
    		if(i < iMax && b[j-1] > a[i]) { // 4 , 4
    			iMin = i + 1;
    		}
    		else if( i > iMin && a[i-1] > b[j]) { // 3 , 5
    			iMax = i - 1;
    		}
    		else {
    			int maxLeft = 0;
    			if(i == 0) {
    				maxLeft = b[j-1];
    			}
    			else if(j == 0) {
    				maxLeft = a[i-1];
    			}
    			else {
    				maxLeft = Math.max(a[i-1], b[j-1]);
    			}
    			if((m+n)%2 == 1) {
    				return maxLeft;
    			}
    			
    			int minRight = 0;
    			if(i == m) {
    				minRight = b[j];
    			}
    			else if(j == n) {
    				minRight = a[i];
    			}
    			else {
    				minRight = Math.min(b[j], a[i]);
    			}
    			
    			return (maxLeft + minRight) / 2.0;
    		}
    		
    	}
    	
		return 0.0;
    	
    }
	
	public static void main(String[] args) throws Exception {// 7/2 (1,3,4,5,6,100,101) ==3  8/2 (4 + (4-1) /2 ) (1,3,4, 5,6   7,100,101)
		//1,3,3, 4,  4, 5,6,7 ,8
		System.out.println(findMedianSortedArrays(new int[] {1,3,4,5,6,7,8} , new int[] {3,4}));
		
	}

}

