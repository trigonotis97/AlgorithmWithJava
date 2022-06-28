package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        int[] arr = new int[n];
        int arrInd = 0;
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.add(queue.poll());
            }
            arr[arrInd++] = queue.poll();
        }
        bw.write("<");
        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(arr[i]));
            if (n != 1 && i != n - 1) bw.write(", ");

        }
        bw.write(">");
        bw.flush();
        bw.close();
    }
}
