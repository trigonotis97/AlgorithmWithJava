package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1012
public class BOJ_1012 {
    static int [][]arr= new int[50][50];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int m,n,k,x,y,tx,ty,cnt=0;

        for (int j = 0; j < 50; j++) {
            Arrays.fill(arr[j],0);
        }

        //input
        int test_case= Integer.parseInt(br.readLine());
        int [] res =new int[test_case];
        for (int i = 0; i < test_case; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            m=Integer.parseInt(st.nextToken());
            n=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                st=new StringTokenizer(br.readLine());
                x=Integer.parseInt(st.nextToken());
                y=Integer.parseInt(st.nextToken());
                arr[y][x]=1;
            }
            cnt=0;
                        
            //loop : search
            for ( y = 0; y < n; y++) {
                for ( x = 0; x < m; x++) {
                    if (arr[y][x]==1){
                        cnt++;
                        findCabbacge(y,x,n,m);
                    }
                }
            }
            res[i]=cnt;

        }
        for (int i:res) {
            //output
            System.out.println(i);
        }


    }

    static void findCabbacge(int y, int x,int my,int mx){
        arr[y][x]=0;
        if(y+1<my && arr[y+1][x]==1){
            findCabbacge(y+1,x,my,mx);
        }
        if (y-1>=0 && arr[y-1][x]==1){
            findCabbacge(y-1,x,my,mx);
        }
        if (x+1<mx && arr[y][x+1]==1){
            findCabbacge(y,x+1,my,mx);
        }
        if (x-1>=0 && arr[y][x-1]==1){
            findCabbacge(y,x-1,my,mx);
        }
    }
}
