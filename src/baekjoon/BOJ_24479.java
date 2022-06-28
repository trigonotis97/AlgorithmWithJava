package baekjoon;

import java.util.Scanner;

public class BOJ_24479 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String tmp;
        int total;
        int result = Integer.MAX_VALUE;
        for (int m = n; m > 0; m--) {
            total = m;
            tmp = String.valueOf(m);
            for (char c : tmp.toCharArray()) {
                total += c - '0';
            }
            if (total == n && m < result) result = m;

        }
        if(result==Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(result);
    }
}
