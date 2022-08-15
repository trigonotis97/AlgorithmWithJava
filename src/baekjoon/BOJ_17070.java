package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//doing
//https://www.acmicpc.net/problem/17070
public class BOJ_17070 {
    static int[][][] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j][0] = Integer.parseInt(st.nextToken());
            }
        }

        arr[0][1][0] = -1; //가로 :0 세로:2 대각 :1
        int[][] dir = {{0, 1}, {1, 1}, {1, 0}};
        boolean[] dirCheck = new boolean[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j][0] == 1) continue;
                for (int k = 0; k < 3; k++) {
                    dirCheck[k] = (i + dir[k][0]) < n && (j + dir[k][1]) < n
                            && (arr[i + dir[k][0]][j + dir[k][1]][0] <= 0);
                }
                dirCheck[1] = dirCheck[1] && dirCheck[0] && dirCheck[2];
                //가로
                if (arr[i][j][0] < 0) {
                    if (dirCheck[0]) arr[i][j + 1][0] += arr[i][j][0];
                    if (dirCheck[1]) arr[i + 1][j + 1][1] += arr[i][j][0];

                }
                //세로
                if (arr[i][j][2] < 0) {
                    if (dirCheck[2]) arr[i + 1][j][2] += arr[i][j][2];
                    if (dirCheck[1]) arr[i + 1][j + 1][1] += arr[i][j][2];
                }

                //대각
                if (arr[i][j][1] < 0)
                    for (int k = 0; k < 3; k++) {
                        if (dirCheck[k]) arr[i + dir[k][0]][j + dir[k][1]][k] += arr[i][j][1];
                    }

            }

        }
        if (arr[n - 1][n - 1][0] == 1) System.out.println(0);
        else
            System.out.println(-(arr[n - 1][n - 1][0] + arr[n - 1][n - 1][1] + arr[n - 1][n - 1][2]));
    }
}
