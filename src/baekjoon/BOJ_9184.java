package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9184 {
    static int [][][]mem=new int[21][21][21];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int []arr=new int[3];
        int initVal=-1;
        for (int [][]row_1:mem) {
            for (int [] row_2: row_1) {
                Arrays.fill(row_2,-1);
            }
        }


        do{
            st =new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                arr[i]=Integer.parseInt(st.nextToken());
            }
            if(arr[1]==-1 && arr[0]==-1&& arr[2] ==-1)
                break;

            System.out.println("w("+arr[0]+", "+arr[1]+", "+arr[2]+") = "+w(arr[0],arr[1],arr[2]));

        }while (true);

    }

    public static int w(int a, int b, int c){
        if(a<=0 || b<=0 || c<=0){
            return 1;
        }
        else if(a>20 || b>20 ||c>20){
            return w(20,20,20);
        }


        if(mem[a][b][c]!=-1){
            return mem[a][b][c];
        }
        else{
            if(a<b && b<c){
                mem[a][b][c]=w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
                return  mem[a][b][c];
            }
            else{
                mem[a][b][c]=w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
                return mem [a][b][c];
            }

        }

    }
}
