package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_2667 {
    static int[][] arr;
    static int[] counter;
    static int curInd = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine());
        arr = new int[h][h];
        counter = new int[h*h];
        curInd = -1;


        //입력력
        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            for (int j = 0; j < h; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h; j++) {
                if (arr[i][j] == 1) {
                    curInd++;
                    dfs(i, j);
                }
            }
        }
        Arrays.sort(counter,0,curInd+1);
        System.out.println(curInd+1);
        for (int i = 0; i <= curInd; i++) {
            System.out.println(counter[i]);
        }
    }

    static void dfs(int x, int y) {
        arr[x][y] = 0;
        counter[curInd]++;
        //동서남북
        if (x - 1 >= 0 && arr[x - 1][y] == 1) {
            dfs(x - 1, y);
        }
        //동서남북
        if (x + 1 <arr[x].length && arr[x + 1][y] == 1) {
            dfs(x + 1, y);
        }
        //동서남북
        if (y - 1 >= 0 && arr[x][y-1] == 1) {
            dfs(x, y-1);
        }
        //동서남북
        if (y + 1 <arr[x].length && arr[x ][y+1] == 1) {
            dfs(x , y+1);
        }
    }
}
