package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //큐의 크기 (이 수만큼 꽉참)
        int m = Integer.parseInt(st.nextToken()); //뽑아내야하는 원소 개수

        //1: poll
        //2: pollfirst addLast
        //3 : polllast add first
        st = new StringTokenizer(br.readLine());
        int count = 0;
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i < n+1 ; i++) {
            deque.addLast(i);
        }

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int dir; //1 이면 first 2 면 last
            if(deque.indexOf(num) > deque.size()/2)
                dir = 2;
            else
                dir = 1;
            while (deque.get(0) != num){
                if(dir == 1) {
                    deque.addLast(deque.pollFirst());
                }
                else {
                    deque.addFirst(deque.pollLast());
                }
                count++;
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}

