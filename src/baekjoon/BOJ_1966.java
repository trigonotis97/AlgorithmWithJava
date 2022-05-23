package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<Integer> queue = new PriorityQueue<>();
        int docCount;
        int targetInd;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            docCount = Integer.parseInt(st.nextToken());
            targetInd = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j <docCount; j++) {

            }
        }
    }
}
