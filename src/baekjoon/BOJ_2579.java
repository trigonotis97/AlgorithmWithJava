package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.max;

//https://www.acmicpc.net/problem/2579
public class BOJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int h= Integer.parseInt(br.readLine());
        int [] arr =new int[h];
        int [] res = new int [h];
        for (int i = 0; i < h; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }

        int cntTri=1;
        res[0]=arr[0];

        //여기 더 깔끔하게 수정하기
        
        if(h>2)
            res[1]=res[0]+arr[1];
        if(h>3)
            res[2]=max(arr[0],arr[1])+arr[2];
        for (int i = 3; i < h; i++) {
            res[i]=max(arr[i-1]+res[i-3],res[i-2])+arr[i];

        }
        System.out.println(res[h-1]);
    }
}
