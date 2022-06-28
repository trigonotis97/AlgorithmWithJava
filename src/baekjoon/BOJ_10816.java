package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int tmp, min, max, mid, count;
        Map<Integer, Integer> map = new HashMap<>();
        int[] marr = new int[m];
        for (int i = 0; i < m; i++) {
            tmp = Integer.parseInt(st.nextToken());
            min = 0;
            max = n-1;
            count = 0;
            if(map.containsKey(tmp)) {
                count = map.get(tmp);
                max = -1;
            }
            while (min <= max) {
                mid = min + (max - min) / 2;
                if (arr[mid] == tmp) {
                    count++;
                    int left = mid - 1;
                    while (left >= 0 && arr[left] == tmp) {
                        count++;
                        left--;
                    }
                    int right = mid + 1;
                    while (right < n && arr[right] == tmp) {
                        count++;
                        right++;
                    }
                    break;
                } else if (arr[mid] > tmp) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            //System.out.print(count + " ");
            map.put(tmp, count);
            marr[i] = count;
        }

        for (int i = 0; i < m; i++) {
            System.out.print(marr[i] + " ");
        }
    }
}


class BOJ_10816_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] mem = new int[20000001];
        for (int i = 0; i < n; i++) {
            mem[Integer.parseInt(st.nextToken()) + 10000000]++;
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] reult = new int[m];
        for (int i = 0; i < m; i++) {
            reult[i] = mem[Integer.parseInt(st.nextToken())+ 10000000];
        }

        for (int i : reult) System.out.print(i+ " ");


    }
}

class BOJ_10816_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> map = new HashMap<>();
        int tmp;
        for (int i = 0; i < n; i++) {
            tmp = Integer.parseInt(st.nextToken());
            if(map.containsKey(tmp)) map.put(tmp, map.get(tmp)+1);
            else map.put(tmp, 1);

        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            tmp = Integer.parseInt(st.nextToken());
            if(map.containsKey(tmp)) bw.write(map.get(tmp)+" ");
            else bw.write("0 ");
        }
        bw.flush();
        bw.close();

    }
}
