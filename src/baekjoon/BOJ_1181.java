package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1181 {
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
                if (o1.length() - o2.length() == 0) { // 길이가 같으면
                    return o1.compareTo(o2); // 사전순
                }
                // 길이가 다르면
                return o1.length() - o2.length(); // 길이순
            }
        });
        for (int i = 0; i < n; i++) {
            if(i+1!=n){
                if (arr[i].equals(arr[i + 1])) {
                    continue;
                }
            }
            System.out.println(arr[i]);
        }
        br.close();
    }
}
