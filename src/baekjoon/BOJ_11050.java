package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11050 {
    static int[] mem = new int[10 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        mem[1] = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(fac(n)/(fac(n-k)*fac(k)));
    }

    static int fac(int a) {
        if(a==0) return 1;
        if (mem[a]==0) mem[a] = fac(a - 1) * a;
        return mem[a];
    }
}
