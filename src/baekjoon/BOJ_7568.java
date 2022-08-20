package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//doing
public class BOJ_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayInd> list =new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new ArrayInd(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),i));
        }
        Collections.sort(list);
        int rank=1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

            }
        }
        for (int j = n; j >= 0; j--) {

            System.out.print("");
        }
    }
    static class ArrayInd implements Comparable<ArrayInd> {
        int weight;
        int length;
        int ind;

        public ArrayInd(int weight, int length, int ind) {
            this.weight = weight;
            this.length = length;
            this.ind = ind;
        }



        @Override
        public int compareTo(ArrayInd o) {
            if (weight > o.weight && length > o.length)
                return 1;
            else if (weight < o.weight && length < o.length)
                return -1;
            else {
                return 0;
            }

        }
    }
}
