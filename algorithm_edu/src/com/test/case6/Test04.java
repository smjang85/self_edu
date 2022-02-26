package com.test.case6;
import java.util.HashSet;
import java.util.Set;

public class Test04 {
    public static int solution(int[][] balloons) {
        Set data1 = new HashSet<>();
        Set data2 = new HashSet<>();
        Set data3 = new HashSet<>();
        Set data4 = new HashSet<>();
        for (int i = 0; i < balloons.length; i++) {
            int x = balloons[i][0];
            int y = balloons[i][1];
            float l = 0;
            if(x == 0) {
                if ( y < 0) { // x: + y: +
                    data1.add(l);
                } else { // x:- y: -
                    data3.add(l);
                }
            }else if(y == 0) {
                if ( x < 0) { // x: + y: +
                    data2.add(l);
                } else { // x:- y: -
                    data4.add(l);
                }
            }else {
                l = (float) (y / x);
                if (x < 0 && y < 0) { // x: + y: +
                    data1.add(l);
                } else if (x > 0 && y < 0) { // x:- y: +
                    data2.add(l);
                } else if (x > 0 && y > 0) { // x:- y: -
                    data3.add(l);
                } else if (x < 0 && y > 0) { // x:+ y: -
                    data4.add(l);
                }
            }
        }

        int count =data1.size() + data2.size() + data3.size() + data4.size();
        return count;
    }

    public static void main(String[] args) throws Exception {
        int[][] v = { { 0, 0 }, { 2, 900 }, { 1, 400 }, { -1, -4 } };
        System.out.println(solution(v));
    }
}