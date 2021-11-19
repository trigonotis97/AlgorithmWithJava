package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());//나무의 수
        int m = Integer.parseInt(st.nextToken()); //나무의 길이
        st = new StringTokenizer(br.readLine(), " ");
        int [] trees=new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees); //1. tree 배열을 정렬
        int min=0; //나무 높이의 최소범위
        int max = trees[n-1];  //나무 높이의 최대 범위


        while (min<=max){
            long sum =0;
            int mid = (min + max) / 2;
            for (int i = trees.length-1; i >=0; i--) { //잘리는 나무 높이 계산
                if(trees[i]>mid){
                    sum+=trees[i]-mid;
                }
                else break;
            }

            if (sum > m) { // sum 이 더 클경우 절단기 높이를 더 높여도 되므로 min 을 올림
                min=mid+1;

            } else if(sum<m){
                max=mid-1;
            }
            else {
                System.out.print(mid);
                return;
            }
        }
        System.out.print(max);
    }
}
