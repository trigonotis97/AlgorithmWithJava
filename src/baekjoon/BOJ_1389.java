package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int[][] mem = new int[n + 1][n + 1];
        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (!graph.containsKey(a)) graph.put(a, new ArrayList<>());
            graph.get(a).add(b);
            if (!graph.containsKey(b)) graph.put(b, new ArrayList<>());
            graph.get(b).add(a);

            mem[a][b] = 1;
            mem[b][a] = 1;
        }

        int minCount = Integer.MAX_VALUE;
        int minNum = 0;
        int totalCount;
        boolean[] visit;
        Queue<Friend> queue;
        for (int i = 1; i < n + 1; i++) {
            queue = new LinkedList<>();
            queue.add(new Friend(i, 0));
            totalCount = 0;
            Friend host;
            visit = new boolean[n + 1];
            while (!queue.isEmpty()) {
                host = queue.poll();
                for (Integer guest : graph.get(host.num)) {
                    if (!visit[guest]) {
                        visit[guest] = true;
                        totalCount += host.count + 1;
                        queue.add(new Friend(guest, host.count + 1));
                    }
                }
            }
            if (minCount > totalCount) {
                minCount = totalCount;
                minNum = i;
            }
        }
        System.out.println(minNum);
    }

    static class Friend {
        int num;
        int count;

        public Friend(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

}
