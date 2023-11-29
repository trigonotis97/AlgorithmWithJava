package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16956 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[][] arr = new String[m][n];
        int result = 1;
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = String.valueOf(s.charAt(j));
                if (".".equals(arr[i][j])) {
                    arr[i][j] = "D";
                } else if (
                        (i != 0
                            &&  !"D".equals(arr[i - 1][j])
                            && !arr[i - 1][j].equals(arr[i][j])) ||
                        (j != 0
                            && !"D".equals(arr[i][j - 1])
                            && !arr[i][j].equals(arr[i][j - 1])) // 현재위치 왼쪽, 위쪽탐색해 딱붙어있으면 false 반환
                ) {
                    result = 0;
                }
            }
        }
        System.out.println(result);
        if (result == 1) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        }
    }
}
