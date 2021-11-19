package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //input
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] n_cards = new int[n];

        for (int i = 0; i < n; i++) {
            n_cards[i]=Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] m_cards = new int[m];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < m; i++) {
            m_cards[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(n_cards);

        int[] out = new int[m];
        for (int i = 0; i < m; i++) {
            int s = 0, e = n - 1;
            int mid = (s+e)/2;
            while (s<=e){
                if (n_cards[mid] == m_cards[i] ) {
                    out[i]=1;
                    break;
                }

                if (n_cards[mid] < m_cards[i]) { // 찾으려는 수가 mid가 가리키는 수보다 클경우 (더 큰 방향 - 오른쪽으로 탐색)
                    s=mid+1;
                }
                else {
                    e=mid-1;
                }
                mid = (s+e)/2;
            }
            System.out.print(out[i]+" ");
        }

    }


}
