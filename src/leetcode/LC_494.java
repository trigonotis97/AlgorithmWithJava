package leetcode;

public class LC_494 {
}
class Solution_494 {
    private int count=0;

    public int findTargetSumWays(int[] nums, int target) {

        recursion(nums,target,0,0);
        return count;
    }
    void recursion(int[]nums ,int target, int index , int sum){
        if(index==nums.length){
            if(sum==target)
                count++;
        }
        else{
            recursion(nums,target,index+1,sum+nums[index]);
            recursion(nums,target,index+1,sum-nums[index]);
        }

    }
}