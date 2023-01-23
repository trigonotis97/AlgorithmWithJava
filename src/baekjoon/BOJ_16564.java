package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/16564
public class BOJ_16564 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] arr= new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int t =arr[0];
        int res =0;
        int res2 =0;
        for (int i = 0; i < n-1; i++) {
            res2=res+(arr[i+1]-arr[i])*(i+1);
            if(res2>k){
                t=arr[i]+(k-res)/(i+1);
                break;
            }else if(res2==k){
                t=arr[i+1];
                break;
            }
            res=res2;
        }
        if(res2<k){
            t=arr[n-1];
            t+=(k-res2)/n;
        }
        System.out.println(t);
    }
}
