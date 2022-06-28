package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int max, sum;
        int[] arr = new int[3];

        while (true) {
            max = sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                if (max < arr[j]) max = arr[j];
                sum += arr[j] * arr[j];
            }
            if (max == 0) break;
            if(sum==max*max*2) bw.write("right"+"\n");
            else bw.write("wrong"+"\n");
        }
        bw.flush();
        bw.close();
    }
}

//6m
