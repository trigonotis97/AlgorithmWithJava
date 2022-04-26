package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LC_139 {
    public static void main(String[] args) {
        Solution_139 s = new Solution_139();
        List<String> l = new ArrayList<>();
        l.add("leet");
        l.add("code");
        System.out.println(s.wordBreak("leetcode", l));
    }
}

class Solution_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>();
        for (String str : wordDict) hs.add(str);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && hs.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}

class Solution_152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max = nums[0];
        int min = nums[0];
        int result = max;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            //현재 원소를 곱했을때 min, max를 각각 구함
            int temp_max = Math.max(curr, Math.max(max * curr, min * curr));
            min = Math.min(curr, Math.min(max * curr, min * curr));

            max = temp_max;

            result = Math.max(max, result); //max 갱신
        }

        return result;
    }
}
