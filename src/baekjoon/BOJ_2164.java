package baekjoon; //DELETE

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ_2164 { //Main
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }

        while (list.size()!=1) {
            list.remove();
            list.addLast(list.remove());
        }

        System.out.println(list.get(0));
        br.close();
    }

}
