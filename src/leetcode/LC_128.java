package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC_128 {
    public static void main(String[] args) {
        Solution_128 s = new Solution_128();
        System.out.println(s.longestConsecutive(new int[]{100,4,200,1,3,2}));

    }
}

class Solution_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int max=0;
        for(int num : set){
            int len=1;
            if(!set.contains(num-1)){
                int target=num+1;
                while (set.contains(target++))
                    len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }
}