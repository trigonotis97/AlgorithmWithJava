package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n + 1][n + 1];
        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        queue.add(1);
        visit[1]=true;
        int friend, size,count=0;
        for (int k = 0; k < 2; k++) {
            size = queue.size();
            for (int h = 0; h < size; h++) {
                friend = queue.poll();
                for (int i = 1; i < n + 1; i++) {
                    if (arr[friend][i] == 1 && !visit[i]) {
                        visit[i]=true;
                        ++count;
                        queue.add(i);
                    }
                }
            }
        }
        System.out.println(count);
    }
}
