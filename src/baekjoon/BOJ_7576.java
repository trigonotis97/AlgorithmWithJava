package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        Set<PointAndCount> unripeTomato = new HashSet<>();
        Queue<PointAndCount> ripeTomato = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) { //익지않은 토마토만 넣기
                    unripeTomato.add(new PointAndCount(i, j, 0));
                } else if (arr[i][j] == 1) {//익은토마토만  queue 에 넣기
                    ripeTomato.add(new PointAndCount(i, j, 0));
                }
            }
        }
        int count = 0;
        PointAndCount p;
        int x, y;
        while (!ripeTomato.isEmpty()) {
            p = ripeTomato.poll();
            for (int i = 0; i < 4; i++) {
                x = p.x + dir[i][1];
                y = p.y + dir[i][0];
                if (x >= 0 && x < m && y >= 0 && y < n && arr[y][x] == 0) {
                    arr[y][x] = 1;
                    unripeTomato.remove(new PointAndCount(y, x, 0));
                    ripeTomato.add(new PointAndCount(y, x, p.count + 1));
                    count = Math.max(count, p.count + 1);
                }
            }
        }
        if (unripeTomato.isEmpty()) System.out.println(count);
        else System.out.println(-1);

    }

    static class PointAndCount implements Serializable {
        int y;
        int x;
        int count;

        PointAndCount(int y, int x, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof PointAndCount) {
                PointAndCount o = (PointAndCount) obj;
                return y == o.y && x == o.x;
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return (String.valueOf(y) + String.valueOf(x)).hashCode();
        }
    }
}
