package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> aStack = new Stack<>();
        ArrayList<String> res = new ArrayList<>();
        int ind = 0;
        int inputNum = 1;
        Integer tmp = 0;
        while (ind != n) {
            if (inputNum < arr[ind]) {
                aStack.push(inputNum++);
                res.add("+");
            } else if (inputNum == arr[ind]) {
                res.add("+");
                res.add("-");
                ind++;
                inputNum++;
            } else if (inputNum > arr[ind]) {
                tmp = aStack.pop();
                if (tmp == arr[ind]) {
                    res.add("-");
                    ind++;
                } else {
                    System.out.print("NO");
                    return;
                }
            }
        }
        for (String i : res) {
            System.out.println(i);
        }
    }
}

