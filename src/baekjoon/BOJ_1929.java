package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean [] arr = new boolean[n+1];



        int count=2;
        while (count<=n){

            if(count>=m) System.out.println(count);
            for (int i = count; i <= n; i+=count) {
                if(!arr[i]) arr[i]=true;
            }

            while (count<=n){
                count++;
                if(count<=n&&!arr[count]) break;
            }
        }
    }
}
