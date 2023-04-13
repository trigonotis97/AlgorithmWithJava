package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//doing
public class BOJ_13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int pos = n;

        int[] arr = new int[222223];

        for (int i = 0; i < 222223; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        arr[pos] = 0;
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(pos);

        while (!dq.isEmpty()) {
            pos = dq.pollFirst();
            System.out.println(pos);
            if (pos == k) {
                System.out.println(arr[pos]);
                return;
            }
            int db = pos * 2;
            if (db < 200000 && arr[pos] < arr[db]) {
                arr[db] = arr[pos];
                dq.addFirst(db);
            }
            int l = pos - 1, r = pos + 1;
            if (l >=0 && l < 200000 && arr[pos] + 1 < arr[l]) {
                arr[l] = arr[pos] + 1;
                dq.addLast(l);
            }
            if (r < 200000 && arr[pos] + 1 < arr[r]) {
                arr[r] = arr[pos] + 1;
                dq.addLast(r);
            }
        }
    }
}
