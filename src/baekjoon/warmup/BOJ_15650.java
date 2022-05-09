package baekjoon.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] mem = new int[n + 1];
        int[] arr = new int[m];
        recursion(arr, mem, 0, n, m);
    }


    public static void recursion(int[] arr, int[] mem, int count, int n, int m) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (mem[i] == 0 && (count == 0 || arr[count - 1] < i)) {
                int[] newMem = mem.clone();
                int[] newArr = arr.clone();
                newMem[i] = 1;
                newArr[count] = i;
                recursion(newArr, newMem, count + 1, n, m);
            }
        }

    }
}
