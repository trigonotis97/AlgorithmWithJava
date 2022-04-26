package leetcode;



import java.util.*;

public class LC_102 {
}

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {
      }

      TreeNode(int val) {
          this.val = val;
      }

      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output= new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<TreeNode> nextLevelQueue=new LinkedList<>();
        if(root==null) {
            return output;
        }
        else{
            queue.add(root);
        }

        while (queue.size()!=0 ){
            List<Integer> nodeList=new ArrayList<>();
            while (queue.size()!=0){
                TreeNode treeNode=queue.poll();
                if(treeNode!=null) {
                    nodeList.add(treeNode.val);
                    if(treeNode.left!=null)
                        nextLevelQueue.add(treeNode.left);
                    if(treeNode.right!=null)
                        nextLevelQueue.add(treeNode.right);
                }
            }
            output.add(nodeList);
            queue=new LinkedList<>(nextLevelQueue);
            nextLevelQueue=new LinkedList<>();
        }

        return output;
    }

}
