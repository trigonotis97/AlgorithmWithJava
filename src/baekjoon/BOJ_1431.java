package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() - o2.length() == 0) {
                    int add1 = 0, add2 = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) - '0' <= 9) {
                            add1 += o1.charAt(i) - '0';
                        }
                        if (o2.charAt(i) - '0' <= 9) {
                            add2 += o2.charAt(i) - '0';
                        }
                    }
                    if (add1 - add2 == 0) {
                        return o1.compareTo(o2);
                    }
                    return add1 - add2;
                } else
                    return o1.length() - o2.length();
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
