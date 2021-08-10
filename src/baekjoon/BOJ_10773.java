package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/10773
//stack, s4
public class BOJ_10773 {
    public static void main(String[] args) throws IOException {
        int []arr=new int[100001];
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int h = Integer.parseInt(br.readLine());
        int ind=0;
        int inputNumber=0;
        for (int i = 0; i < h; i++) {
            inputNumber=Integer.parseInt(br.readLine());
            if(ind==0 && inputNumber==0)
                continue;
            if(inputNumber==0) {
                arr[--ind] = 0;
            }
            else{
                arr[ind++]=inputNumber;
            }
        }

        int total=0;
        for (int i = 0; i < ind; i++) {
            total+=arr[i];
        }
        System.out.println(total);

    }
}
