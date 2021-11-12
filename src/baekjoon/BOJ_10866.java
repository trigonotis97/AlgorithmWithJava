package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_10866 {
    static Deque<Integer> deque =new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h =Integer.parseInt(br.readLine());
        Integer x;
        for (int i = 0; i < h; i++) {
            String []s=br.readLine().split(" ");
            switch (s[0]){
                case "push_front" :
                    deque.addFirst(Integer.parseInt(s[1]));
                    break;
                case "push_back" :
                    deque.addLast(Integer.parseInt(s[1]));
                    break;
                case "pop_front":
                    x = deque.pollFirst();
                    System.out.println(x==null? -1 : x);
                    break;
                case "pop_back":
                    x = deque.pollLast();
                    System.out.println(x==null? -1 : x);
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.size()==0?1:0);
                    break;
                case "front":
                    x=deque.peekFirst();
                    System.out.println(x==null? -1 : x);
                    break;
                case "back":
                    x=deque.peekLast();
                    System.out.println(x==null? -1 : x);
                    break;
            }
        }
    }
}
