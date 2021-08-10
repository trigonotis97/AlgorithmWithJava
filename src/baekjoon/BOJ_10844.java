package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844 {
     static  Long [][] num_arr ;

    //https://www.acmicpc.net/problem/10844
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long res=0;
        num_arr= new Long[n+1][10];

        for (int i = 0; i < 10; i++) {
            num_arr[1][i]=1L;
        }

        for (int i = 1 ; i <=9; i++) {
            res+=recursion(n,i);
        }
        System.out.println(res% 1000000000);
    }
    static long recursion(int digit, int val){
        if(digit==1){
            return num_arr[digit][val];
        }
        if (num_arr[digit][val]==null) {
            if(val==0)
                num_arr[digit][val]=recursion(digit-1,1);
            else if(val==9)
                num_arr[digit][val]=recursion(digit-1,8);
            else {
                num_arr[digit][val]=recursion(digit-1,val-1)+ recursion(digit-1,val+1);
            }
        }
        return num_arr[digit][val] % 1000000000;

    }
}
