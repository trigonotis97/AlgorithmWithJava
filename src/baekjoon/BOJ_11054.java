package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] inc = new int[n];
        int[] dec = new int[n];

        inc[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j]) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
            if(inc[i]==0) inc[i] = 1;
        }

        int result=0;
        dec[n-1]=1;
        for (int i = n-1; i >=0 ; i--) {
            for (int j = n-1; j >i ; j--) {
                if(num[i]>num[j]) dec[i] = Math.max(dec[i], dec[j] + 1);
            }
            if(dec[i]==0) dec[i] = 1;
            int result1 = inc[i] + dec[i] - 1;
            if(result< result1) result = result1;
        }
        System.out.println(result);
    }
}
