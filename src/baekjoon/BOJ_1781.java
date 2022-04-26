package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<Integer> pQueue = new PriorityQueue<>();
        CupRamen[] arr = new CupRamen[n];
        CupRamen c;
        int count=0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), "");
            arr[i]=new CupRamen(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }
        Arrays.parallelSort(arr);
        int size,num;
        for (CupRamen q : arr ) {
            size = pQueue.size();
            if(size<q.deadLine) pQueue.offer(q.num);
            else if(size==q.deadLine){
                num = pQueue.peek();
                if(num<q.num){
                    pQueue.poll();
                    pQueue.offer(q.num);
                }
            }
        }

        while (!pQueue.isEmpty()) count += pQueue.poll();

    }

    static class CupRamen implements Comparable<CupRamen> {
        int deadLine;
        int num;

        CupRamen(int d, int n) {
            deadLine = d;
            num = n;
        }

        @Override
        public int compareTo(CupRamen o) {
            if (this.deadLine == o.deadLine) {
                if (this.num == o.num)
                    return 0;
                return this.num > o.num ? -1 : 1;
            }
            return this.deadLine > o.deadLine ? 1 : -1;
        }
    }
}
