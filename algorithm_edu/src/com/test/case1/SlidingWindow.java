package com.test.case1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/*
5
Problem statement
Given a window size, W and a stream of number, S. You can see only W numbers in the window. Each time you receive a number from stream S, print max numbers in sliding window.

Input
[W]
[N1]
[N2]
...
Where W is the number of the window size, and Nn represents a element in the stream.

Note that, you can assume following things.

An element in the stream will be an integer in the range, -3,000,000,000 ? Nn ? 3,000,000,000.
the window size W will be an integer in the range, 0 < W ? 3,000,000,000.

Output
After you read first W + 1 lines, each time you read the number from the input, print max numbers in sliding window.

Input Example
(Window size W=2 and number stream is S = [2, 1, 2, -1, 3])

2
2
1
2
-1
3
Output Example
2
2
2
3
 */
public class SlidingWindow {
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
