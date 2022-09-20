package leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC_131 {
}
//doing
class Solution_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> out = new LinkedList<>();
        int length = s.length();
        String n = "";
        for (int i = 0; i < length; i++) {
            int front = i;
            for (int j = i; j <length ; j++) {
                int end = j;
                while (s.substring(front,front).equals(s.substring(end,end))){
                    front++;
                    end++;
                    if (front >= end) {
                        
                    }
                }
            }
        }
        return out;
    }
}
