package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int [][]mem=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<str1.length()+1;i++){
            for (int j=0;j<str2.length()+1;j++) {
                if(i==0 || j==0) mem[i][j]=0;
                else {
                    if(str1.charAt(i-1)==str2.charAt(j-1)) {
                        mem[i][j]=mem[i-1][j-1]+1;
                    }
                    else {
                        mem[i][j]=Math.max(mem[i-1][j],mem[i][j-1]);
                    }
                }
            }
        }



        System.out.println(mem[str1.length()][str2.length()]);
    }
}
