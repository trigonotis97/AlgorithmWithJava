package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC_105 {
    public static void main(String[] args) {
        Solution_105 s=new Solution_105();
        s.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}

class Solution_105 {
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        this.preorder = preorder;
        dfs(inorder, 0, root);
        return root;
    }

    void dfs(int[] inorder, int preInd, TreeNode root) {
        int rootNum = preorder[preInd];
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootNum) {
                if (i != 0) { //left 트리가 있는경우
                    TreeNode node = new TreeNode(preorder[preInd+1]);
                    root.left = node;
                    dfs(Arrays.copyOfRange(inorder, 0, i), preInd + 1, node);
                }
                if (inorder.length - i - 1 != 0) { //right 트리가 있는경우
                    TreeNode node = new TreeNode(preorder[preInd + i+1]);
                    root.right = node;
                    dfs(Arrays.copyOfRange(inorder, i + 1, inorder.length), preInd + i+1, node);
                }
            }
        }
    }
}
