package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int h=Integer.parseInt(st.nextToken());
        int cost=Integer.parseInt(st.nextToken());
        int [] arr=new int[h];
        for (int i = 0; i < h; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        int i=h-1;
        int result=0;
        do{
            if(arr[i]<=cost) {
                cost -= arr[i];
                result++;
            }
            else i--;
        }while (cost!=0);

        System.out.println(result);
    }
}
