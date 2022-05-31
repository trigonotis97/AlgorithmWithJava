package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int a, b;
        ArrayList<Integer> list;
        boolean[] visit = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (graph.containsKey(a)) graph.get(a).add(b);
            else {
                list = new ArrayList<>();
                list.add(b);
                graph.put(a, list);
            }
            if (graph.containsKey(b)) graph.get(b).add(a);
            else {
                list = new ArrayList<>();
                list.add(a);
                graph.put(b, list);
            }
        }
        Queue<Integer> queue;
        int count=0;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                queue = new LinkedList<>();
                count++;
                queue.add(i);
                while (!queue.isEmpty()) {
                    a = queue.poll();
                    if(!visit[a]) {
                        visit[a] = true;
                        if(graph.containsKey(a))
                            for (int k : graph.get(a)) {
                                queue.add(k);
                            }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
