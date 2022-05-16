package baekjoon;

import java.util.Scanner;

public class BOJ_11726 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] dp = new int[n + 1];
        if(n==1) {
            System.out.println(1);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 10007;
        }
        System.out.println(dp[n]);

    }
}
