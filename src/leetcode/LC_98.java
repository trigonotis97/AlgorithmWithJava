package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC_98 {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution_98 {
    boolean result = true;

    public boolean isValidBST(TreeNode root) {
        dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return result;
    }

    void dfs(TreeNode root, long min, long max) {
        if (root.left != null) {
            if (root.left.val < root.val && root.left.val > min)
                dfs(root.left, min, root.val);
            else {
                result = false;
                return;
            }
        }
        if (root.right != null) {
            if (root.val < root.right.val && root.right.val < max) {
                dfs(root.right, root.val, max);
            } else {
                result = false;
                return;
            }
        }
    }
}