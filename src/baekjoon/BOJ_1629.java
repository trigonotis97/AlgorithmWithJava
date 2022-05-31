package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_1629 {
    static int c;
    static int a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(pow(b));

    }

    static long pow(int b) {
        if (b == 0) return 1;
        long tmp = pow(b / 2);
        tmp = tmp * tmp % c;
        if (b % 2 == 0) return tmp;
        return a * tmp % c;
    }
}


