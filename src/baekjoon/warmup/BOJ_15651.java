package baekjoon.warmup;

import java.io.*;
import java.util.StringTokenizer;


public class BOJ_15651 {
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        recursion(new StringBuilder(), 0, n, m);
        bw.flush();
    }

    public static void recursion(StringBuilder s, int count, int n, int m)  throws IOException{
        if (count == m) {
            bw.write(s+"\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            recursion(new StringBuilder(s + String.valueOf(i) + " "), count + 1, n, m);
        }
    }
}
