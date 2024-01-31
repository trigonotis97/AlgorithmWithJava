package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1446 {
    private static int INF = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        List<Road> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if(e>d)continue;
            if(e-s<=l)continue;
            list.add(new Road(s, e, l)) ;

        }
        Collections.sort(list, new Comparator<Road>() {
            @Override
            public int compare(Road o1, Road o2) {
                return o1.start - o2.start;
            }
        });
        int curPos = 0;
        int[] dist = new int[INF];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        int ind = 0;
        while (curPos <= d) {
            if (ind < list.size() && curPos == list.get(ind).start) {
                Road r = list.get(ind);
                dist[r.end] = Math.min(dist[r.end], dist[curPos] + r.length);
                ind ++;
            } else {
                dist[curPos + 1] = Math.min(dist[curPos + 1], dist[curPos] + +1);
                curPos++;
            }

        }
        System.out.println(dist[d]);

    }

    static class Road {
        int start;
        int end;
        int length;

        Road(int s, int e, int l) {
            start = s;
            end = e;
            length = l;
        }
    }
}
