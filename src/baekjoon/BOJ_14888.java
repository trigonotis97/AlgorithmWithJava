package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {

    static int[] num;
    static int n;
    static int minNum = Integer.MAX_VALUE;
    static int maxNum = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] op = new int[4];
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        recursion(op, 1, num[0]);
        System.out.print(maxNum + "\n" + minNum);

    }

    static void recursion(int[] op, int ind, int result) {
        if (ind == n) {
            if (result < minNum) minNum = result;
            if (result > maxNum) maxNum = result;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] != 0) {
                int res = result;
                switch (i) {
                    case 0:
                        res += num[ind];
                        break;
                    case 1:
                        res -= num[ind];
                        break;
                    case 2:
                        res *= num[ind];
                        break;
                    case 3:
                        res /= num[ind];
                        break;

                }
                int[] newOp = op.clone();
                newOp[i]--;
                recursion(newOp, ind + 1, res);
            }
        }
    }
}
