package baekjoon.warmup;

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class BOJ_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MyHeap_11279 myHeap = new MyHeap_11279();
        int [] resArr = new int[n];
        int printInd = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) resArr[printInd++] = myHeap.print();
            else myHeap.insert(input);
        }

        for (int i = 0; i < printInd; i++) {
            System.out.println(resArr[i]);
        }

    }


}
class MyHeap_11279{
    List<Integer> list = new ArrayList<>();

    void insert(int num){
        int e = list.size();
        int s = 0;
        int m ;
        while (s<e){
            m = (s+e)/2;
            if(num >= list.get(m)) s += m+1;
            else  e=m;
        }
        list.add(e,num);
    }
    int print(){
        int res=0;
        if(!list.isEmpty()){
            res = list.get(list.size()-1);
            list.remove(list.size()-1);
        }
        return res;
    }
}
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                Integer res = queue.poll();
                if(res == null) res = 0;
                sb.append(res+"\n");
            }
            else{
                queue.add(input);
            }
        }
        System.out.println(sb);
    }
}


