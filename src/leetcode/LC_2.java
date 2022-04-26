package leetcode;

import java.util.List;

public class LC_2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode q = l1;
        ListNode w = l2;
        for (int i = 0; i < 7; i++) {
            l1.next = new ListNode(9);
            l1 = l1.next;
            if(i<4) {
                l2.next = new ListNode(9);
                l2 = l2.next;
            }
        }
        Solution_2 s = new Solution_2();
        ListNode n = s.addTwoNumbers(q, w);
        System.out.println(n);
    }

}

class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode out = new ListNode();

        recursion(l1, l2, out,0);

        return out.next;
    }

    void recursion(ListNode l1, ListNode l2, ListNode out, int carry) {

        if(l1==null &&l2==null){
            if(carry>0) {
                ListNode newNode = new ListNode(carry);
                out.next = newNode;
            }

            return;
        }
        ListNode newNode = new ListNode();
        out.next = newNode;
        out=out.next;
        if (l1 != null && l2 != null) {
            int num = carry + l1.val + l2.val;
            out.val = num % 10;
            recursion(l1.next, l2.next, out,num / 10);
        }

        else if (l1 != null) {
            int num = carry + l1.val;
            out.val = num % 10;

            recursion(l1.next, null, out,num / 10);
        }

        else if (l2 != null) {
            int num = carry + l2.val;
            out.val = num % 10;
            recursion(null, l2.next, out,num / 10);
        }

    }
}

