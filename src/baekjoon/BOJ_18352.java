package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//done
public class BOJ_18352 {
    private static final int INF = 300001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> nodeMap = new HashMap<>();
        int [] dist = new int[n+1];
        Arrays.fill(dist,INF);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            List<Integer> destList;
            if(nodeMap.containsKey(n1)){
                destList = nodeMap.get(n1);
            }
            else {
                destList = new ArrayList<>();
            }
            destList.add(n2);
            nodeMap.put(n1,destList);
        }

        //logic
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(x,0));
        dist[x] = 0;
        do{
            Node item = queue.poll();
            List<Integer> destList = nodeMap.get(item.num);
            if(item.weight + 1 > k )
                break;
            if(destList==null) continue;
            for(int target : destList){
                if(dist[target] > item.weight + 1 ){
                    dist[target] = item.weight + 1;
                    queue.add(new Node(target, dist[target]));
                }
            }
        }while (!queue.isEmpty());
        int cnt =0;
        for (int i = 1; i <= n; i++) {
            if(dist[i] == k) {
                System.out.println(i);
                cnt++;
            }
        }
        if(cnt == 0)
            System.out.println(-1);

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

