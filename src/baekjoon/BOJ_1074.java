package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int h = (int) Math.pow(2, n);
        int midx = 0, midy = 0;
        r++;
        c++;
        int res = 0;

        while (true) {
            int mid = h / 2 == 0 ? 1 : h / 2;

            if ((r == midy + mid && c == midx + mid) && h == 1) {
                break;
            } else if (r <= midy + mid && c <= midx + mid) {//1

            } else if (r <= midy + mid && c > midx + mid) { //2

                res = res + h * h / 4 * 1;
                midx += mid;
            } else if (r > midy + mid && c <= midx + mid) { //3
                res = res + h * h / 2;
                midy += mid;
            } else { //4
                res = res + h * h / 4 * 3;
                midx += mid;
                midy += mid;
            }
            h = mid;

        }
        System.out.println(res);
    }

}
