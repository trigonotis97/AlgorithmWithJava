package leetcode;

public class LC_198 {
}

class Solution_198 {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        else if(nums==null || nums.length==0)
            return 0;

        int max_1 =0;
        int max_2 =0, tmp;

        for (int num : nums) {
            max_1 = Math.max(num + max_1, max_2);
            tmp = max_2;
            max_2 = max_1;
            max_1 = tmp;
        }
        return Math.max(max_1,max_2);
    }
}
