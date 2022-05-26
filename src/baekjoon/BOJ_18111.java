package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int block = Integer.parseInt(st.nextToken());
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        int[][] terra = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                terra[i][j] = Integer.parseInt(st.nextToken());
                if (low > terra[i][j]) low = terra[i][j];
                if (high < terra[i][j]) high = terra[i][j];
            }
        }
        int b, time, minTime, height;
        minTime = Integer.MAX_VALUE;
        height = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            b = block;
            time = 0;
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (terra[j][k] > i) {
                        b += terra[j][k] - i;
                        time += 2 * (terra[j][k] - i);
                    } else if (terra[j][k] < i) {
                        b -= i - terra[j][k];
                        time += i - terra[j][k];
                    }
                }
            }
            if ((minTime >= time && height < i) && b >= 0) {
                minTime = time;
                height = i;
            }
        }
        System.out.println(minTime + " " + height);
    }
}

//1h
