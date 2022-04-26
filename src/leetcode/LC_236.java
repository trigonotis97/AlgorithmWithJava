package leetcode;

public class LC_236 {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

//https://github.com/fpdjsns/Algorithm/blob/master/leetcode/medium/236.%20Lowest%20Common%20Ancestor%20of%20a%20Binary%20Tree.cpp
class Solution_236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) return root;
        if (l != null) return l;
        if (r != null) return r;
        return null;
    }

}