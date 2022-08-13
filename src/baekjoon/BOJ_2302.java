package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2302 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int result = 1;
        int preVal = 0;

        for (int i : arr) {
            result *= fib(i  - preVal);
            preVal = i;
//            System.out.println(result);
        }
        if (preVal < n) result *= fib(n - preVal+1);
        System.out.println(result);

    }

    static int fib(int input) {
//        System.out.print(input);
        if (input == 0) return 0;
        else if (input == 1) return 1;
        return fib(input - 1) + fib(input - 2);
    }

}
