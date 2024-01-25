package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int curPos = 0, curLen = 0;
        Road[] arr = new Road[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            arr[i] = new Road(s, e, l);
        }
        Arrays.sort(arr);
        /*
        for (int i = 0; i < n; i++) {
            if (curPos >= arr[i].start && arr[i].end - curPos > arr[i].length) {
                curPos=arr[i].end;
                curLen += arr[i].length
            } else if(curPos<arr[i].start && Qatt[curPosp ]) {
            }
        }
         */
    }

    static class Road implements Comparable<Road> {
        int start;
        int end;
        int length;

        Road(int s, int e, int l) {
            start = s;
            end = e;
            length = l;
        }

        @Override
        public int compareTo(Road o) {
            return o.start - this.start;
        }
    }
}
