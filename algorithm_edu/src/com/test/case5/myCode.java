package com.test.case5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class myCode {
	static long printMax(List<Long> S, int n, long k) {
		long max = 0;
		for (int i = 0; i <= n - k; i++) {
			max = S.get(i);
			for (int j = 1; j < k; j++) {
				if (S.get(i + j) > max) {
					max = S.get(i + j);
				}
			}
		}
		return max;
	}

	public static void main(String args[]) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long W =  Long.parseLong(br.readLine());
		List<Long> S = new LinkedList<Long>();
		List<Long> S2 = new LinkedList<Long>();
		int cnt = 0;
		int cnt2 = 0;
		
		long firstMax = 0;
		while (true) {
			try {
				Long number = Long.parseLong(br.readLine());
				if(cnt <= Integer.MAX_VALUE) {
					S.add(cnt, number);
					cnt++;
					if ((cnt + 1) > W) {
						long max = printMax(S, S.size(), W);
						System.out.println(max);
					}
				}else {
					if(firstMax == 0) {
						firstMax = printMax(S, S.size(), W);
					}
					
					S2.add(cnt2, number);
					cnt2++;
					
					long max = printMax(S2, S2.size(), W);
					if(firstMax > max) {
						System.out.println(firstMax);
					}else {
						System.out.println(max);
					}
				}
				

				
			} catch (Exception e) {
				break;
			}
		}
	}
}
