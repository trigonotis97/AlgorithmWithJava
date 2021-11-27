package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        int cnt=1,maxCnt=1,maxInd=0;
        for (int i = 1; i < n; i++) {
            if(arr[i]==arr[i-1]) cnt++;
            else cnt =1;
            if(cnt>maxCnt){
                maxCnt = cnt;
                maxInd = i;
            }
        }
        System.out.println(arr[maxInd]);
    }
}
