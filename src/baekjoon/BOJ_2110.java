package baekjoon;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken()); //집의개수
        int c = Integer.parseInt(st.nextToken()); //설치해야할 공유기 개수
        int[] houses = new int[h];
        for (int i = 0; i < h; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        long min =1;
        long max =houses[h-1]-houses[0];
        long mid = (min+max) / 2;

        long ans = 1;

        //이분탐색 시작
        while (min<=max){
            long cnt = 1; // 공유기 개수
            int prev = houses[0]; // 공유기를 배열 앞에서 부터 설치.
            for (int i = 1; i < h; i++) {
                int dist = houses[i]-prev; // 이전 설치위치와 거리차이 구하기
                if (dist >= mid) { //mid 의 거리차이보다 diff가 더 클경우 공유기를 설치한다.
                    prev = houses[i];
                    cnt++;
                }
            }
            if (cnt >= c) { //c개 이상 설치할 수 있는 경우
               ans = Math.max(ans, mid);
               min = mid + 1;
            } else {
                max=mid-1;
            }
            mid = (min + max) / 2;
        }

        System.out.print(ans);
    }
}
