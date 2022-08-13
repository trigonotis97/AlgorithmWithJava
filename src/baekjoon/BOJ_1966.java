package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<Integer> queue;
        int docCount;
        int targetInd;
        //List<Integer> queue;
        int[] arr;
        int[] result = new int[n];
        int resInd = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            docCount = Integer.parseInt(st.nextToken());
            targetInd = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            queue = new LinkedList<>();
            arr = new int[docCount];
            for (int j = 0; j < docCount; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                queue.add(arr[j]);
            }
            Arrays.sort(arr);
            int orderInd = docCount - 1;
            int tmp;
            int count = 0;
            while (!queue.isEmpty()) {
                tmp = queue.peek();
                if (tmp == arr[orderInd] && targetInd == 0) {
//                    System.out.println(++count);
                    result[resInd++] = ++count;
                    break;
                } else if (tmp < arr[orderInd]) {
                    queue.add(queue.poll());
                } else {
                    queue.poll();
                    orderInd--;
                    count++;

<<<<<<< Updated upstream
                }
                targetInd = targetInd == 0 ? queue.size() - 1 : targetInd - 1;
=======
            for (int j = 0; j <docCount; j++) {
    
>>>>>>> Stashed changes
            }
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
