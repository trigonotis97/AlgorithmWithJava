package baekjoon;

import java.util.Scanner;

public class BOJ_13909 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int cnt=0;
        for (int i = 1; i *i<=n ; i++) {
            cnt++;
        }
        System.out.println(cnt);
    }
}
