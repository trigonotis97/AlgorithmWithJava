package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
    static int[][] dir = {{0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0},{-1, 0, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[h][n][m];
        int tomato = 0, days = 0;
        Queue<Tomato3D> ripeTomato = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 0) tomato++;
                    else if (arr[i][j][k] == 1) ripeTomato.add(new Tomato3D(i, j, k));
                }
            }
        }
        Tomato3D t;
        int size,z,y,x;
        while (!ripeTomato.isEmpty()&&tomato!=0) {
            size = ripeTomato.size();
            for (int i = 0; i < size; i++) {
                t = ripeTomato.poll();
                for (int j = 0; j < 6; j++) {
                    z = t.z + dir[j][0];
                    y = t.y + dir[j][1];
                    x = t.x + dir[j][2];
                    if (x >= 0 && x < m && y >= 0 && y < n &&z>=0 &&z<h&& arr[z][y][x] == 0) {
                        arr[z][y][x] = 1;
                        tomato--;
                        ripeTomato.add(new Tomato3D(z,y, x));
                    }
                }
            }
            days++;
        }
        if(tomato>0) System.out.println(-1);
        else System.out.println(days);

    }

    static class Tomato3D implements Serializable {
        int y;
        int x;
        int z;

        Tomato3D(int z, int y, int x) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Tomato3D) {
                Tomato3D o = (Tomato3D) obj;
                return y == o.y && x == o.x && z == o.z;
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return (String.valueOf(y) + String.valueOf(x) + String.valueOf(z)).hashCode();
        }
    }
}
