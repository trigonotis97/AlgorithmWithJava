package baekjoon.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        int res = a * b * c;
        String s = String.valueOf(res);
        for(char ch: s.toCharArray()){
            arr[ch - '0']++;
        }
        for (int i : Arrays.stream(arr).toArray()) {
            System.out.println(i);
        }
    }
}
