package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.max;


public class BOJ_12865 {
    //https://www.acmicpc.net/problem/12865

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result;
        int max_num=100001;
        StringTokenizer st=new StringTokenizer(br.readLine());
        int h=Integer.parseInt(st.nextToken());
        int max_weight=Integer.parseInt(st.nextToken());
        int [][] arr = new int[100001][100001];
        /*
        for (int i = 0; i < h; i++) {

        int [][] valMem = new int[h+1][max_weight+1];
        for (int i = 1; i <= h; i++) { //입력
            st=new StringTokenizer(br.readLine());
            stuff[i][0]= Integer.parseInt(st.nextToken()); //w
            stuff[i][1]= Integer.parseInt(st.nextToken()); //v
        }
        //dp
        for (int i = 0; i <=h ; i++) {
            for (int w = 0; w <=max_weight ; w++) {
                if(i==0||w==0){
                    valMem[i][w]=0;

                }
                else if(w<stuff[i][0])
                    valMem[i][w]=valMem[i-1][w];
                else
                    valMem[i][w]=max(valMem[i-1][w],valMem[i-1][w-stuff[i][0]]+stuff[i][1]);

            }
        }


        System.out.println(result);
*/
    }
}
