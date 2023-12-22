package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//douing
public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Meeting> list = new ArrayList<>();
        StringTokenizer st;
        int start, time;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());
            Meeting tmp = new Meeting(start, time);
            list.add(tmp);
        }
        Collections.sort(list);
        int ind = 0;
        int curTime = list.get(0).start;    
        for (; ind < n; ind++) {

        }
    }
    static class Meeting implements Comparable<Meeting>{
        int start;
        int time;

        public Meeting(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.start>o.start)
                return 1;
            else if(this.start<o.start){
                return -1;
            }
            return 0;
        }
    }
}



/*
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
 */