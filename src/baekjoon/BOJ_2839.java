package baekjoon;

import java.util.Scanner;

public class BOJ_2839 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] dp = new int[n + 1];
        if(n>=3) dp[3] = 1;
        if(n>=5) dp[5] = 1;
        for (int i = 6; i <= n ; i++) {
            if(dp[i-5]!=0) dp[i] = dp[i - 5]+1;
            if(dp[i-3]!=0) {
                if(dp[i]!=0 &&dp[i-3]+1<dp[i]) dp[i] = dp[i - 3] + 1;
                else if(dp[i]==0) dp[i] = dp[i - 3] + 1;
            }
        }
        System.out.println(dp[n]==0? -1 : dp[n]);

    }
}

//12mf
