package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_221 {
}

class Solution_221 {
    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        Collections.sort(list);
        return list.get(k - 1);
    }

    void dfs(TreeNode head) {
        list.add(head.val);
        if (head.left != null)
            dfs(head.left);
        if (head.right != null)
            dfs(head.right);
    }
}

//이게진짜 221번
//https://leetcode.com/problems/maximal-square/
class Solution_221_1 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        int r = matrix.length, c = matrix[0].length;
        int dp[][] = new int[r + 1][c + 1];

        for (int y = 1; y <= r; y++) {
            for (int x = 1; x < c; x++) {
                if (matrix[y - 1][x - 1] == '1') {
                    dp[y][x] = Math.min(dp[y][x - 1], Math.min(dp[y - 1][x - 1], dp[y - 1][x])) + 1;
                    max = Math.max(max, dp[y][x]);
                }
            }
        }
        return max * max;
    }
}