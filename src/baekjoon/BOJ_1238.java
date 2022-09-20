package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

//doing
//https://www.acmicpc.net/problem/1238
public class BOJ_1238 {
    static Map<Integer, ArrayList<ArriveAndCost>> graph = new HashMap<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int partyPlace = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[partyPlace] = 0;
        int place, s, e, t, max;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            if (!graph.containsKey(s)) graph.put(s, new ArrayList<>());
            graph.get(s).add(new ArriveAndCost(e, t));
        }hh

        Queue<Integer> queue = new LinkedList<>();
        queue.add(partyPlace);
        //x마을부터 모든 경로를 다 탐색해야 한다.

        //end point
        while (!queue.isEmpty()) {
            place = queue.poll();
            for (ArriveAndCost a : graph.get(place)) {
                if (dp[a.arrive] > a.cost + dp[place]) {
                    dp[a.arrive] = a.cost + dp[place];
                    queue.add(a.arrive);
                }
            }
        }

//        //start point
//        int[] dps = new int[n + 1];
//        Arrays.fill(dps,Integer.MAX_VALUE);
//        dps[partyPlace] = 0;
//        TwoPointAndCost twoPlace;
//        Queue<TwoPointAndCost> costQueue = new LinkedList<>();
//        boolean[] visit = new boolean[n + 1];
//        for (int i = 1; i <=n ; i++) {
//            visit[i]=true;
//            if(i==partyPlace) continue;
//            for(ArriveAndCost a : graph.get(i)){
//                costQueue.add(new TwoPointAndCost(i, a.arrive, a.cost));
//            }
//            while (!costQueue.isEmpty()) {
//                twoPlace = costQueue.poll();
//                for (ArriveAndCost a : graph.get(twoPlace.end)) {
//
//                    if (a.arrive==partyPlace&&dps[twoPlace.start]>a.cost+twoPlace.cost) {
//                        dps[twoPlace.start] = a.cost+twoPlace.cost;
//                        costQueue.add(new TwoPointAndCost(twoPlace.start,a.arrive,dps[twoPlace.start]));
//                    }
//                    if(!visit[twoPlace.end]) {
//                        costQueue.add(new TwoPointAndCost(twoPlace.end, a.arrive, a.cost));
//                        visit[twoPlace.end] = true;
//                    }
//
//
//                }
//            }
//        }

        int[] dps = new int[n + 1];
        Arrays.fill(dps, Integer.MAX_VALUE);
        dps[partyPlace] = 0;
        boolean[] visit;
        for (int i = 1; i <= n; i++) {
            if (i == partyPlace) continue;

            dps = new int[n + 1];
            Arrays.fill(dps, Integer.MAX_VALUE);
            dps[partyPlace] = 0;

            visit = new boolean[n + 1];
            queue.add(i);
            while (!queue.isEmpty()) {
                place = queue.poll();
                if (!visit[place]) {
                    visit[place] = true;
                    for (ArriveAndCost a : graph.get(place)) {

                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
//            costQueue = new LinkedList<>();
            queue.add(i);

        }

        max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max * 2);
    }

    static class ArriveAndCost {
        int arrive;
        int cost;

        ArriveAndCost(int arrive, int cost) {
            this.arrive = arrive;
            this.cost = cost;
        }
    }

    static class TwoPointAndCost {
        int start;
        int end;
        int cost;

        TwoPointAndCost(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
