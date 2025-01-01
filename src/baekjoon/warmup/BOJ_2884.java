package baekjoon.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2884 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer a = Integer.parseInt(st.nextToken());
        Integer b = Integer.parseInt(st.nextToken());

        if(b>=45) {
            System.out.println(a+" "+(b-45));
        }else if(a==0){
            System.out.println(23+" "+(b-45+60));
        }else {
            System.out.println(a-1+" "+(b-45+60));
        }
    }
}
