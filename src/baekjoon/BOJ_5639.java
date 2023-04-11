package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input ="";
        Tree root = null;
        Tree startRoot = null;
        while((input = br.readLine()) != null) {
            int inputVal = Integer.parseInt(input);
            if(root == null){
                root = new Tree(inputVal);
                startRoot = root;
            }
            else {
                preOrder(root,inputVal);
            }
        }
        postOrder(startRoot);
    }

    static void preOrder(Tree root, int inputVal) {
        if(root.val < inputVal){
         if(root.rignt == null)
             root.rignt = new Tree(inputVal);
         else
             preOrder(root.rignt,inputVal);
        }
        else {
            if(root.left == null)
                root.left = new Tree(inputVal);
            else
                preOrder(root.left,inputVal);
        }
    }
    static void postOrder(Tree root) {
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.rignt);
        System.out.println(root.val);
    }

    static class Tree {
        int val;
        Tree left;
        Tree rignt;
        Tree(int val){
            this.val = val;
        }
    }
}
