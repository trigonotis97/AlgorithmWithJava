package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2156
//dp
//doing
public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n + 1];
        int result = 0;
        for (int i = 0; i < n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        int doubleWineStack = 2;
        for (int i = 2; i < n; i++) {
            if (doubleWineStack == 2) {
                if (wines[i - 2] + wines[i + 1] < wines[i]) {
                    result = result - wines[i - 2] + wines[i];
                } else {
                    doubleWineStack = 0;
                }
            } else {
                result = result + wines[i];
                doubleWineStack++;
            }

        }
        System.out.println(result);

    }
}

class BOJ_2156_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n + 1];

        for (int i = 0; i < n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        int[][] mem = new int[3][2];

        if (n == 1) {
            System.out.println(wines[0]);
            return;
        }

        mem[2][0] = mem[0][0] = wines[0];
        mem[0][0] += wines[1];
        mem[1][0] = wines[1];
        mem[0][1] = 2;
        mem[1][1] = 1;
        mem[2][1] = 0;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                switch (mem[j][1]) {
                    case 2:
                        mem[j][1] = 0;
                        break;
                    case 1:
                    case 0:
                        mem[j][1]++;
                        mem[j][0] += wines[i];
                        break;
                }
            }
        }

        System.out.println(Math.max(Math.max(mem[0][0], mem[1][0]), mem[2][0]));
    }
}

class BOJ_2156_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n + 1];

        for (int i = 0; i < n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        int[][] mem = new int[n][2];

        if (n == 1) {
            System.out.println(wines[0]);
            return;
        } else if (n == 2) {
            System.out.println(wines[0] + wines[1]);
            return;
        }

        mem[0][0] = wines[0]; //cost
        mem[0][1] = 1; //stack

        mem[1][0] = wines[0] + wines[1]; //cost
        mem[1][1] = 2; //stack

        for (int i = 2; i < n; i++) {
            if (mem[i - 1][1] == 2) {
                if (mem[i - 1][0] >= mem[i - 2][0] + wines[i]) { //skip this turn
                    mem[i][0] = mem[i - 1][0];
                    mem[i][1] = 0;
                } else {
                    mem[i][0] = mem[i - 2][0] + wines[i];
                    mem[i][1] = 1;
                }
            } else {
                if (mem[i - 1][0] + wines[i] > mem[i - 2][0] + wines[i]) {
                    mem[i][0] = mem[i - 1][0] + wines[i];
                    mem[i][1] = 2;
                } else {
                    mem[i][0] = mem[i - 2][0] + wines[i];
                    mem[i][1] = 1;
                }
            }
        }

        System.out.println(mem[n-1][0]);
    }
}
