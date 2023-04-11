package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
//doing
public class BOJ_13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int curPos = n;

        int [] arr = new int[100001];
        arr[curPos] = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(curPos);
        while (!queue.isEmpty()){

        }

    }
}
