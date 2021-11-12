package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2482 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        int k =Integer.parseInt(br.readLine());
        int[][] d = new int [n + 5][n + 5];
        final int r = 1000000003;

        for (int i = 1;i <= n;++i)
            d[i][0] = 1;
        for (int i = 1;i <= n;++i)
            d[i][1] = d[i - 1][1] + 1;

        for (int i = 2; i < n; ++i)
            for (int j = 2;j <= k;++j)
                d[i][j] = (d[i - 1][j] + d[i - 2][j - 1]) % r;

        System.out.println((d[n - 1][k] + d[n - 3][k - 1]) % r);
    }
}
