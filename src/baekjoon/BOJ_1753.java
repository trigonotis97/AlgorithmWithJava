package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1753 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        Map<Integer, Set<Node>> nodeMap = new HashMap<>();
        int[] dist = new int[v + 1];
        Arrays.fill(dist,300001);

        //input
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Set<Node> list;
            if (nodeMap.containsKey(n1)) {
                list = nodeMap.get(n1);
            } else {
                list = new HashSet<>();
            }
            list.add(new Node(n2, w));
            nodeMap.put(n1, list);
        }

        //logic

        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[start] = 0;
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            Set<Node> list = nodeMap.get(current.num);
            if (list == null || list.isEmpty())
                continue;
            for (Node node : list) {
                if (dist[node.num] > dist[current.num] + node.weight ) {
                    dist[node.num] = dist[current.num] + node.weight;
                    queue.add(node);
                }
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (dist[i] == 300001) {
                out.append("INF");
            } else {
                out.append(dist[i]);
            }
            out.append("\n");
        }
        bw.write(out.toString());
        br.close();
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if(this.weight == o.weight )
                return this.num - o.num;
            else return this.weight - o.weight;
        }
    }
}

