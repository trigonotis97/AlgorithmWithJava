package baekjoon.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String [] result=br.readLine().split(" ");
        if(result.length==0)
            System.out.print(result.length);
        else if(result[0].equals(""))
            System.out.print(result.length-1);
        else
            System.out.print(result.length);

    }
}
