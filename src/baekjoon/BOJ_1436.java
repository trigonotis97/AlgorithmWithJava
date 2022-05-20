package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_1436 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String sb;
        int num = 665;
        int count = 0;
        StringBuilder tmp = new StringBuilder();
        StringBuilder six = new StringBuilder("666");
        while (count != n) {
            num++;
            sb = String.valueOf(num);
            int length = sb.length() - 3;
            for (int i = 0; i <= length; i++) {
                tmp.setLength(0);
                for (int j = i; j < i + 3; j++) {
                    tmp.append(sb.charAt(j));
                }
                if (tmp.compareTo(six) == 0) {
                    count++;
                    break;
                }
            }
        }
        System.out.print(num);

    }
}
