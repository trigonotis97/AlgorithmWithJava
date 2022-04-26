package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x;
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)==Math.abs(o2)){
                    if(o1.equals(o2)) return 0;
                    else return o1 > o2 ? 1 : -1;
                }
                else
                    return Math.abs(o1)>Math.abs(o2)?1:-1;
            }
        });
        Integer tmp = null;
        for (int i = 0; i <n ; i++) {
            x = Integer.parseInt(br.readLine());
            if(x!=0){
                pq.add(x);
            }
            else {
                tmp = pq.poll();
                if(tmp==null) System.out.println(0);
                else System.out.println(tmp);
            }
        }
    }
}
