package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        Integer k = null;
        StringTokenizer st;
        Queue<Long> pQueue;
        long result, a, b, tmp;

        long[] arr = new long[n];


        for (int i = 0; i < n; i++) {
            result = 0;
            k = Integer.parseInt(br.readLine());
            pQueue = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < k; j++) {
                pQueue.add(Long.parseLong(st.nextToken()));
            }


            while (pQueue.size() > 1) {
                a = pQueue.poll();
                b = pQueue.poll();
                tmp = a + b;
                result += tmp;
                pQueue.add(tmp);
            }
            arr[i] = result;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
