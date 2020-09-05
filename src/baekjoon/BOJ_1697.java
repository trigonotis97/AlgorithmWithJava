package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    static int [] time;

    public static void main(String[] args)  throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int target=Integer.parseInt(st.nextToken());
        time=new int[100001];
        bfs(start,target);
        System.out.println(time[target]);

    }


    static void bfs(int curInd,int targetInd){
        Queue<Integer> q=new LinkedList<>();
        q.add(curInd);
        //TODO
        while (!q.isEmpty()){
            int next=q.poll();
            if(next==targetInd)
                return;
            if(next+1<=100000 && time[next+1]==0 ) {
                q.add(next + 1);
                time[next+1]=time[next]+1;
            }
            if(next-1>=0 && time[next-1]==0 ) {
                q.add(next - 1);
                time[next-1]=time[next]+1;
            }
            if(next*2<=100000 && time[next*2]==0) {
                q.add(next *2);
                time[next*2]=time[next]+1;
            }

        }

    }


}
