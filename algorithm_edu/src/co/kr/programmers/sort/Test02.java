package co.kr.programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 가장 큰 수
 */
class Comp implements Comparator<String>{
	public int compare(String o1, String o2) {
		return (o2 + o1).compareTo(o1 + o2);
	}
}

public class Test02 {
	public static String solution(int[] numbers) {
		String[] arr = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			arr[i] = String.valueOf(numbers[i]);

		//Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
		Arrays.sort(arr, new Comp());
		if (arr[0].equals("0"))
			return "0";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++)
			sb.append(arr[i]);

		return sb.toString();
	}


	public static void main(String[] args) throws Exception {
		int[] numbers = { 6, 10, 2 };
		System.out.println(solution(numbers));
	}
}
