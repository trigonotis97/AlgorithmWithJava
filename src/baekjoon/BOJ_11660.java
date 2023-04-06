package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (i != 0) arr[i][j] += arr[i - 1][j];
                if (j != 0) arr[i][j] += arr[i][j - 1];
                if (i != 0 && j != 0) arr[i][j] -= arr[i - 1][j - 1];

            }
        }
        int x1, y1, x2, y2;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            y1 = Integer.parseInt(st.nextToken()) - 1;
            x1 = Integer.parseInt(st.nextToken()) - 1;
            y2 = Integer.parseInt(st.nextToken()) - 1;
            x2 = Integer.parseInt(st.nextToken()) - 1;
            int sum = arr[y2][x2];
            if (y1 > 0) {
                sum -= arr[y1 - 1][x2];
            }
            if (x1 > 0) {
                sum -= arr[y2][x1 - 1];
            }
            if (x1 > 0 && y1 > 0) {
                sum += arr[y1 - 1][x1 - 1];
            }
            list.add(sum);
        }
        list.forEach(System.out::println);
    }
}
