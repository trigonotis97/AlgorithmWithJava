package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> resultList = new ArrayList<>();
        int index = 0;
        for (; index< n-m; index++) {
            resultList.add(Arrays.asList(index,index+1));
        }
        int i= index;
        index++;
        for (; index <n ; index++) {
            resultList.add(Arrays.asList(i,index));
        }

        //모두 1개일경우 맨앞에 붙이기
        for (List<Integer> l : resultList) {
            System.out.println(l.get(0) + " "+ l.get(1));
        }
    }
}
