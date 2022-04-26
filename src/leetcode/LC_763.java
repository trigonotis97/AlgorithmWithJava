package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_763 {
    public static void main(String[] args) {
        Solution_763 s = new Solution_763();
        System.out.println(s.partitionLabels("ababcbacadefegdehijhklij"));
    }
}

class Solution_763 {
    public List<Integer> partitionLabels(String s) {
        int[] end = new int[26]; //알파벳 개수만큼 배열

        //한글자씩 가장 마지막 위치 저장.
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            int index = c - 97;
            end[index] = i;
        }
        int max = 0;
        List<Integer> result = new ArrayList<>();
        int size = 0;

        for (int i = 0; i< s.length(); ++ i) {
            int alphabet = s.charAt(i) - 97;
            max = Math.max(end[alphabet], max);
            if (max == i) { //현재 인덱스가 max 일경우 list에 저장
                result.add(size+1);
                size = 0;
            } else if (max > i) {
                size += 1;
            }
        }
        return result;
    }
}