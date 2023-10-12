package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int throwNum = (int)Math.round((double) n*15/100);
        Arrays.sort(arr);
        int sum = 0;
        for (int i = throwNum; i < n-throwNum ; i++) {
            sum +=arr[i];
        }
        int amount = (int) Math.round((double)sum/(n-throwNum*2));
        System.out.println(amount);
    }
}
