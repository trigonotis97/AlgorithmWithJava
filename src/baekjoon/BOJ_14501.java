package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] dp = new int[n + 1];
        int t, p, max = 0, curMax = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            curMax = Math.max(dp[i], curMax);
            if (i + t <= n) {
                dp[i + t] = Math.max(dp[i + t], curMax + p);
                max = Math.max(dp[i + t], max);
            }
        }
        System.out.println(max);

    }
}
