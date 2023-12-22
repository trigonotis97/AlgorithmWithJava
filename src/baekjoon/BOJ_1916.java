package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//done
public class BOJ_1916 {
    public static void main(String[] args) throws IOException {

        final int INF = 1000000001;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Map<Integer, List<Node>> nodeMap = new HashMap<>();
        StringTokenizer st ;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            List<Node> list;
            if (nodeMap.containsKey(n1)) {
                list = nodeMap.get(n1);
            } else {
                list = new ArrayList<>();
            }
            list.add(new Node(n2, w));
            nodeMap.put(n1, list);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        //logic
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int [] dist = new int[n+1];
        Arrays.fill(dist,INF);
        dist[start] = 0;

        queue.add(new Node(start,0));
        while (!queue.isEmpty() ){
            Node current  = queue.poll();
            List<Node> list = nodeMap.get(current.num);
            if(list == null || list.isEmpty()) continue;
            if(current.weight > dist[current.num])
                continue;

            for(Node node : list) {
                if (dist[node.num] > dist[current.num] + node.weight) {
                    dist[node.num] = dist[current.num] + node.weight;
                    queue.add(new Node(node.num, dist[node.num]));
                }
            }
        }
        System.out.println(dist[end]);
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
