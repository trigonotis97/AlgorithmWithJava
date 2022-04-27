package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_103 {
}

class Solution_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> out = new LinkedList<>();

        if (root == null) {
            return out;
        }
        Deque<TreeNode> leftQueue = new LinkedList<>();
        Deque<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.offer(root);
        boolean leftToRight = true;
        TreeNode node;
        List<Integer> list = new LinkedList<>();
        while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {

            if (leftToRight) {
                node = leftQueue.pollFirst();
                list.add(node.val);
                if (node.left != null) rightQueue.add(node.left);
                if (node.right != null) rightQueue.add(node.right);

                if (leftQueue.isEmpty()) {
                    leftToRight = false;
                    out.add(list);
                    list = new LinkedList<>();
                }
            } else {
                for(TreeNode t : rightQueue){
                    if (t.left != null) leftQueue.add(t.left);
                    if (t.right != null) leftQueue.add(t.right);
                }
                while (!rightQueue.isEmpty()){
                    node = rightQueue.pollLast();
                    list.add(node.val);
                }

                leftToRight = true;
                out.add(list);
                list = new LinkedList<>();
            }

        }

        return out;
    }

}
