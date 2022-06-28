package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n;
        int[][] arr;
        StringTokenizer tokenizer;
        int[][] mem;
        for (int i = 0; i < t; i++) {
            //input
            n = Integer.parseInt(br.readLine());
            arr = new int[n][2];
            mem = new int[n][2];
            for (int k = 0; k < 2; k++) {
                tokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[j][k] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            if(n==1){
                System.out.println(Math.max(arr[0][0],arr[0][1]));
                continue;
            }

            mem[0][0] = arr[0][0];
            mem[0][1] = arr[0][1];

            mem[1][0] = arr[1][0] + mem[0][1];
            mem[1][1] = arr[1][1] + mem[0][0];

            for (int j = 2; j < n; j++) {
                mem[j][0] = Math.max(mem[j - 2][1], mem[j - 1][1]) + arr[j][0];
                mem[j][1] = Math.max(mem[j - 2][0], mem[j - 1][0]) + arr[j][1];
            }
            System.out.println(Math.max(mem[n - 1][0], mem[n - 1][1]));

        }

    }
}
