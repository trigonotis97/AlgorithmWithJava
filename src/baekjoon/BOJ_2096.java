package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int [] input = new int[3];
        int [] minNum = new int[3];
        int [] maxNum = new int[3];
        int [] tmp = new int[3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }
            if(i==0){
                for (int j = 0; j <3 ; j++) {
                    minNum[j] = input[j];
                    maxNum[j] = input[j];
                }
            }
            else{
                tmp[0] = Math.max(maxNum[0],maxNum[1]) + input[0];
                tmp[2] = Math.max(maxNum[2],maxNum[1]) + input[2];
                tmp[1] = Math.max(Math.max(maxNum[2],maxNum[0]),maxNum[1]) + input[1];
                for (int j = 0; j < 3; j++) {
                    maxNum[j] = tmp[j];
                }


                tmp[0] = Math.min(minNum[0],minNum[1]) + input[0];
                tmp[2] = Math.min(minNum[2],minNum[1]) + input[2];
                tmp[1] = Math.min(Math.min(minNum[2],minNum[0]),minNum[1]) + input[1];
                for (int j = 0; j < 3; j++) {
                    minNum[j] = tmp[j];
                }
                /*
                maxNum[0] += Math.max(input[0],input[1]);
                maxNum[2] += Math.max(input[2],input[1]);
                maxNum[1] += Math.max(Math.max(input[1],input[0]),input[2]);

                minNum[0] += Math.min(input[0],input[1]);
                minNum[2] += Math.min(input[2],input[1]);
                minNum[1] += Math.min(Math.min(input[1],input[0]),input[2]);
                 */
            }

        }
        System.out.println(Math.max(Math.max(maxNum[1],maxNum[0]),maxNum[2]) + " " + Math.min(Math.min(minNum[1],minNum[0]),minNum[2]));
    }
}
