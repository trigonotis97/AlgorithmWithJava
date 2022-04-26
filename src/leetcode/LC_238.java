package leetcode;

import java.util.Locale;

public class LC_238 {
    public static void main(String[] args) {
        Locale j4Locale = Locale.JAPAN;
        System.out.println(        j4Locale.toString()
);
    }
}
class Solution_238 {
    public int[] productExceptSelf(int[] nums) {
        int [] ans=new int[nums.length];
        ans[0]=1;
        for(int i=1;i<nums.length;i++) //앞에서 뒤로 루흐
            ans[i] = ans[i-1] * nums[i-1];

        for(int i=nums.length-2; i>=0; i--) // 뒤에서 앞으로 루프
            nums[i] = nums[i+1] * nums[i];

        for(int i=0;i<nums.length-1;i++) //앞에서 뒤로 돌면서
            ans[i] = ans[i] * nums[i+1];
        return ans;

    }
}


class Solution2 {
    public int rob(TreeNode root) {
        int[] result = robSub(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null)
            return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] result = new int[2];

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];

        return result;
    }
}
