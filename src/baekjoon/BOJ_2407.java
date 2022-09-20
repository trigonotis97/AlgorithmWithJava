package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//doing
public class BOJ_2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long nf = 1, mf = 1;
        for (int i = n; i >= n - m+1; i--) {
            nf *= i;
        }
        for (int i = m; i > 0; i--) {
            mf *= i;
        }
        System.out.println(nf/mf);
    }
}
