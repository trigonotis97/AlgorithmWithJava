package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int min = 0;
            int max = n - 1;
            int mid = n / 2;
            int num = Integer.parseInt(st.nextToken());
            boolean isExist = false;

            while (min <= max) {
                mid = (max + min) / 2;
                if (num == arr[mid]) {
                    isExist = true;
                    break;
                } else if (num < arr[mid]) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            if (isExist) System.out.println(1);
            else System.out.println(0);
        }
    }
}
       
