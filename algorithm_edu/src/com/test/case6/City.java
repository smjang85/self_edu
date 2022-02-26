package com.test.case6;

public class City {
	public static int getDistance(int[][] city, int start1, int start2){
        int dis = 0;
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < city.length; i++){
        	for(int j = 0; j < city[i].length; j++){
        		if(city[i][j] == 0) {
        			int distance1 = Math.abs(i-start1);
            		int distance2 = Math.abs(j-start2);
        			dis = distance1 + distance2;
        			if(dis != 0 && min > dis) {
            			min = dis;
            		}
        			if(min == 1) {
        				return min;
        			}
        			
        		}
        	}
        }
		return min;
	}
	
	
	
    public static int[][] solution(int[][] city){
    	int[][] answer = city;
        
        for(int i = 0; i < city.length; i++){
        	for(int j = 0; j < city[i].length; j++){
        		if(city[i][j] == 1) {
        			answer[i][j] = getDistance(city,i,j);
        		}else {
        			answer[i][j] = 0;
        		}
        	}
        }
        
        for(int i = 0; i < answer.length; i++){
        	for(int j = 0; j < answer[i].length; j++){
        		System.out.print(answer[i][j] + " ");
        	}
        	System.out.println("");
        }
        return answer;
    }
    
	
	public static void main(String[] args) throws Exception {
		int[][] city= {
				{0,0,0,1},  
				{0,1,1,1}, 
				{0,1,0,1}   
			};
		
		System.out.println(solution(city));
	}
}
