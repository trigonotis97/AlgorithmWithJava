package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4811 {
    static long[][] mem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        long result;


        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            mem = new long[n + 1][n + 1]; //[hole][half];
            int hole = n, half = 0;
            result = rec(hole, half);
            System.out.println(result); //result
        }
    }

    static long rec(int hole, int half) {
        if(hole==0 &&half==0) return 1;
        else if(hole<0 || half<0) return 0;
        if (mem[hole][half] == 0) {
            mem[hole][half] = rec(hole - 1, half + 1) + rec(hole, half - 1);
        }
        return mem[hole][half];
    }
}
