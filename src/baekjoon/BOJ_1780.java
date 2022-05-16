package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {
    static int[][] arr;
    static int []result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][n];
        result = new int[3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0, n);
        for (int i: result) {
            System.out.println(i);
        }

    }

    static void recursion(int y, int x, int len) {
        int base = arr[y][x];
        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                if (base != arr[i][j]) {
                    for (int k = y; k < y + len; k += len / 3) {
                        for (int l = x; l < x + len; l += len / 3) {
                            recursion(k, l, len / 3);
                        }
                    }
                    return;
                }
            }
        }
        result[base + 1]++;
    }

}
