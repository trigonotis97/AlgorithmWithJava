package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        int [] numCount = new int [8001];

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }
            else {
                int num = map.get(arr[i]);
                map.put(arr[i],num+1);
            }
        }
        Arrays.sort(arr);
        List<Integer> modeList = new ArrayList<>();
        int modeCount = map.get(arr[0]);
        modeList.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if(modeCount<map.get(arr[i])){
                modeList = new ArrayList<>();
                modeList.add(arr[i]);
                modeCount = map.get(arr[i]);
            }
            else if(modeCount == map.get(arr[i]) && modeList.get(modeList.size()-1) != arr[i] ){
                modeList.add(arr[i]);
            }
        }
        int amount, mid, mode, diff; // 산술평균, 중앙값, 최빈값, 범위

        mid = arr[n / 2];
        amount = (int) Math.round((double) sum / n);
        diff = arr[n-1] - arr[0];
        mode = modeList.size() == 1 ? modeList.get(0) : modeList.get(1);



        System.out.println(amount);
        System.out.println(mid);
        System.out.println(mode);
        System.out.println(diff);

    }
}
