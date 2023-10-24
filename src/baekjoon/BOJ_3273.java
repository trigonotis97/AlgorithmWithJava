package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int b = 0,f = 1;
        int count = 0;
        //f 위치 잡기
        for (; f < n ; f++) {
            if(arr[b]+arr[f]>target) {
                break;
            }
        }
        f--;
        while (true){
            if(b >= f)
                break;

            if(arr[b] + arr[f] > target){
                f--;
            }
            else if (arr[b] + arr[f] < target){
                b++;
            }
            else {
                count++;
                b++;
                f--;
            }
        }

        System.out.println(count);
    }
}
