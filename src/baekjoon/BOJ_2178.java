package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        boolean[][] arr = new boolean[n][m ];
        String tmp;
        for (int i = 0; i < n; i++) {
            tmp = br.readLine();
            for (int j = 0; j < m; j++) arr[i][j] = tmp.charAt(j) == '1';

        }

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, 0));
        Pos p;
        int x,y;
        while (!q.isEmpty()) {
            p = q.poll();
            if(!arr[p.y][p.x]) continue;
            arr[p.y][p.x] = false;
            p.count += 1;
            if (p.y == n-1 && p.x == m-1) {
                System.out.println(p.count);
                break;
            }
            for (int i = 0; i < 4; i++) {
                y = p.y + dir[i][0];
                x = p.x + dir[i][1];
                if (y>=0 &&y<n && x>=0&&x<m &&arr[y][x]) {
                    q.add(new Pos(y, x, p.count ));
                }
            }

        }
    }

    static class Pos {
        int x;
        int y;
        int count;

        Pos(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

}
