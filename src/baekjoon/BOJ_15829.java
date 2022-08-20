package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15829 {
    public static void main(String []args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int r =31, m=1234567891;
        int l = Integer.parseInt(br.readLine());
        String s =br.readLine();

        long out=0;
        for (int i = l-1; i >= 0; i--) {
            out =((((out)<<5)-out)+(s.charAt(i) - 'a' + 1))%m;

        }
        System.out.println(out%m);


    }
}
