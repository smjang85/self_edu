package com.test.case3;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
ex
TTTHTHHT,3
HHHHH,4
THTHT,4
 */
public class Coin {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println("Hello Goorm! Your input is " + input);
		if(null == input || "".equals(input)) {
			
		}else {
			String[] strArr = input.split("[,]");
			
			String coinsStr = strArr[0];
			int k = Integer.parseInt(strArr[1]);
			
			String[] coins = coinsStr.split("");
			//System.out.println("coinsStr : " + coinsStr);
			//System.out.println("k : " + k);
			
			if("".equals(coinsStr.replaceAll("H", ""))){
				System.out.println("0");
			}else {
				boolean result = true;
				boolean loopFlag = true;
				int i = 0;
				int cnt = 0;
				while(loopFlag) {
					if("T".equals(coins[i])){
						//System.out.println("coins.length : " + coins.length);
						//System.out.println("i :" + i);
						//System.out.println("k :" + k);
						if( coins.length - i < k ) {
							result = false;
							loopFlag = false;
						}else {
							for(int j = i; j < i+k; j++) {
								if("T".equals(coins[j])) {
									coins[j] = "H";	
								}else {
									coins[j] = "T";
								}
							}
							cnt++;
							String reversedCoinStr = "";
							for(String coin : coins) {
								reversedCoinStr += coin;
							}
							//System.out.println("reversedCoinStr : " +reversedCoinStr);
							if("".equals(reversedCoinStr.replaceAll("H", ""))){
								loopFlag = false;
							}
							
						}
						i=0;
					}
					i++;
				}
				if(result == false) {
					System.out.println("X");
				}else {
					System.out.println(cnt);
				}
			}
		}
	}
}
