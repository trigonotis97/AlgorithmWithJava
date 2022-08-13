package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}
*/
public class LC_437 {
}

class Solution_437 {
    int targetNum;
    public int pathSum(TreeNode root, int targetSum) {
        TreeNode dp=new TreeNode();
        targetNum=targetSum;
        return dfs(root,dp,0);
    }
    int dfs(TreeNode node,TreeNode dp,int count){

        return count;
    }


}

