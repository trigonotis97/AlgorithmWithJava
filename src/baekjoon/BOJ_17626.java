package baekjoon;

import java.util.Scanner;

public class BOJ_17626 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] dp = new int[n + 1];
        int[] pow = new int[n + 1];
        boolean overN = false;
        int ind = 1;
        //dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            if (!overN) {
                pow[i] = i * i;
                ind = i;
                if (pow[i] > n) overN = true;
            }

            for (int j = ind; j >= 1; j--) {
                if (i == pow[j]) dp[i] = 1;
                int num = i - pow[j];
                if (num > 0 && dp[num] != 0) {
                    if (dp[i] == 0) dp[i] = dp[num] + 1;
                    else dp[i] = Math.min(dp[num] + 1, dp[i]);
                }
            }
        }
        System.out.print(dp[n]);
    }
}
