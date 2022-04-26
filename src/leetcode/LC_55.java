package leetcode;

public class LC_55 {
    public static void main(String[] args) {
        Solution_55 s =new Solution_55();
        System.out.println(s.canJump(new int []{2,0,0}));
    }
}

class Solution_55 {
    public boolean canJump(int[] nums) {
        if(nums.length==1)
            return true;
        int length=0;
         int i=0;
        for ( i = 0; i < nums.length-1; i++,length--) {
            length=Math.max(length,nums[i]);
            if(length==0)
                return false;
        }
        return true;
    }
}
