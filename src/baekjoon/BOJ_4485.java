package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//doing
//https://www.acmicpc.net/problem/4485
//g4
public class BOJ_4485 {
    static final int INF = 200000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        StringTokenizer st;
        while (true){
            n = Integer.parseInt(br.readLine());
            if(n==0) break;

            int [][] arr = new int[n][n];
            int [][] warr = new int[n][n];
            Arrays.fill(warr,INF);
            for (int i = 0; i < n; i++) {
                st=new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            //logic
            int count = 0;

        }


    }
    class Point {
        int x; int y;
        Point(int y, int x){
           this.x = x;
           this.y = y;
        }
    }
}
