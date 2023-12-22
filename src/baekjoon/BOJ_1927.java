package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int in = Integer.parseInt(br.readLine());
            if (in > 0) {
                queue.add(in);
            } else {
                Integer out = queue.poll();
                if (out == null)
                    System.out.println(0);
                else
                    System.out.println(out);
            }
        }
    }
}
