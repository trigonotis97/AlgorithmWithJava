package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_12865 {
    //https://www.acmicpc.net/problem/12865

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result;
        StringTokenizer st=new StringTokenizer(br.readLine());
        int h=Integer.parseInt(st.nextToken());
        int max_weight=Integer.parseInt(st.nextToken());
        int [][] arr = new int[100001][100001];
        for (int i = 0; i < h; i++) {

        }


        System.out.println(result);

    }
}
