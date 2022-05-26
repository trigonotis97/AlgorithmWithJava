package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int max = 0;
        int min = n;
        int lanLangth = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        int mid = (min + max) / 2;
        int count;
        while (min >= max) {
            count = 0;
            for (int i = 0; i < n; i++) {
                count += arr[i] / mid;
            }
            if (count >= m && lanLangth < mid) {
                min = mid;
             //   lanLangth
            }
            else if(count >= m && lanLangth > mid){

            }
            mid = (min + max) / 2;
        }
    }
}
