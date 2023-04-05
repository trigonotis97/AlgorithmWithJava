package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer,LinkTree> map = new HashMap<>();
        int a ,b;
        StringTokenizer st;
        for (int i = 0; i < n-1; i++) {
            //링크트리에 저장
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(!map.containsKey(a)){
                map.put(a, new LinkTree(b));
            } else {
                LinkTree node = map.get(a);
                node.neighbors.add(b);
                map.put(a, node);
            }

            if(!map.containsKey(b)){
                map.put(b, new LinkTree(a));
            } else {
                LinkTree node = map.get(b);
                node.neighbors.add(a);
                map.put(b, node);
            }

        }
        //부모찾기
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        while (!queue.isEmpty()){
            Integer parent = queue.poll();
            LinkTree node = map.get(parent);

            for (Integer val : node.neighbors) {
                LinkTree childTree = map.get(val);
                childTree.parent = parent;
                childTree.neighbors.remove(parent);
                map.put(val,childTree);
                queue.add(val);
            }
        }
        //출력
        for (int i = 2; i <= n; i++) {
            System.out.println(map.get(i).parent);
        }


    }
    static class LinkTree{
        Integer parent;
        List<Integer> neighbors = new ArrayList<>();
        LinkTree(int n){
            neighbors.add(n);
        }
    }
}
