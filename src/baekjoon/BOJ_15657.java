package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657 {
    static int n;
    static int m;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs("",0,0);
    }
    static void dfs(String s, int start, int cnt){
        if(cnt == m){
            System.out.println(s);
            return;
        }
        for (int i = start; i < n ; i++) {
            dfs(s + arr[i]+ " ",i,cnt+1);

        }
    }
}

class c72{
    public static void main(String[] args) {
        int n = 1000007;
        for (int i = 2; i < n ; i++) {
            if(n%i ==0 ){
                System.out.println(i);
                break;
            }
        }
    }
        }
