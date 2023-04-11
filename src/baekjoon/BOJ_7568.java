package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_7568 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayInd> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new ArrayInd(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
        }
        Collections.sort(list,Collections.reverseOrder());
        int rate = 1, stack = 1;
        Map<Integer, Integer> result = new HashMap<>();
        ArrayInd prev = null;
        for (ArrayInd item : list) {
            if (prev == null) {
                result.put(item.ind, rate);
            } else if ((prev.weight > item.weight && prev.length > item.length) ||
                    (prev.weight == item.weight && prev.length > item.length) ||
                    (prev.weight > item.weight && prev.length == item.length))
            {
                rate += stack;
                result.put(item.ind, rate);
                stack = 1;
            } else {
                result.put(item.ind, rate);
                stack++;
            }
            prev = item;
        }

        for (int j = 0; j < n; j++) {
            System.out.print(result.get(j) + " ");
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
            if ((weight > o.weight && length > o.length) ||
                    (weight > o.weight && length == o.length) ||
                    (weight == o.weight && length > o.length))
                return 1;
            else if ((weight < o.weight && length < o.length) ||
                    (weight < o.weight && length == o.length) ||
                    (weight == o.weight && length < o.length))
                return -1;
            else if ((weight == o.weight && length == o.length) ||
                    (weight < o.weight && length > o.length) ||
                    (weight > o.weight && length < o.length)) {
                return 0;
            }
            return 0;
        }
    }
}

class temp7568{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            int rank = 1;
            int[] target = board[i];
            for (int j = 0; j < board.length; j++) {
                int[] tmp = board[j];
                if (i != j) {
                    if (target[0] < tmp[0] && target[1] < tmp[1]) {
                        rank++;
                    }
                }
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb);
    }
}