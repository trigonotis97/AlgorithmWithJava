package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2156
//dp
public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] wines = new int[n+1];
        int result=0;
        for (int i = 0; i <n ; i++) {
            wines[i]=Integer.parseInt(br.readLine());
        }
        result = wines[0]+wines[1];
        int doubleWineStack=2;
        for (int i = 2; i < n; i++) {
            if(doubleWineStack==2){
                if(wines[i-2]+wines[i+1]<wines[i]) {
                    result = result-wines[i-2]+wines[i];
                }
                else {
                    doubleWineStack=0;
                }
            }
            else {
                result=result+wines[i];
                doubleWineStack++;
            }


        }
        System.out.println(result);

    }
}

