package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17404 {
    //https://www.acmicpc.net/problem/17404
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine());
        int[][] house = new int[h][3];
        int[][] costs = new int[h][3];
        String[] tmp;
        int result=1000*1000+1;
        for (int i = 0; i < h; i++) {
            tmp = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(tmp[j]);
            }
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) { //첫번째 집 색 고정
                if(i==j) costs[0][j] = house[0][j];
                else costs[0][j]=1000*h+1;
            }

            for (int j = 1; j <h ; j++) {
                costs[j][0]=Math.min(costs[j-1][1],costs[j-1][2])+house[j][0];
                costs[j][1]=Math.min(costs[j-1][0],costs[j-1][2])+house[j][1];
                costs[j][2]=Math.min(costs[j-1][1],costs[j-1][0])+house[j][2];
            }

            for (int j = 0; j < 3; j++) {
                if(i==j) continue;
                result=Math.min(result,costs[h-1][j]);
            }
        }
        System.out.println(result);
    }
}

