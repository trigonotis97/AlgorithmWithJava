package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        StringTokenizer st = new StringTokenizer(b.readLine());
        int[] arr = new int[n];
        int max =0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        boolean[] primeArr = new boolean[max + 1];
        int count=2;
        primeArr[1] = true;
        for (int j = count; j <=max ; j++) {
            if(!primeArr[j]){
                for (int i = j+j; i <= max; i+=j) {
                    if(!primeArr[i]) primeArr[i] = true;
                }
            }
        }
        int result =0;
        for( int i : arr){
            if(!primeArr[i]) result++;
        }
        System.out.println(result);
    }
}
