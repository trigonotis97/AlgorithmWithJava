package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606 {

    static int [][] arr;
    static boolean [] visit;
    static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int h=Integer.parseInt(br.readLine());
        int n=Integer.parseInt(br.readLine());
        arr=new int [h+1][h+1];
        visit=new boolean[h+1];
        int [] tmp=new int[2];

        for (int i = 1; i <= n ; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            tmp[0]=Integer.parseInt(st.nextToken());
            tmp[1]=Integer.parseInt(st.nextToken());
            arr[tmp[0]][tmp[1]]=1;
            arr[tmp[1]][tmp[0]]=1;
        }
        dfs(1);
        System.out.println(result);


    }

    static void dfs(int ind){
        visit[ind]=true;
        for (int i = 1; i <arr.length ; i++) {
            if(arr[ind][i]==1 && !visit[i]){
                result++;
                dfs(i);
            }
        }
    }

}
