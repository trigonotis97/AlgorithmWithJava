package leetcode;

import java.util.Arrays;

public class LC_215 {
}
class Solution_215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}