package leetcode;

import java.util.List;

public class LC_19 {
}


class Solution_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lastNode=head;
        ListNode targetNode;

        for (int i = 0; i < n; i++) {
            lastNode=lastNode.next;
        }
        targetNode = head;

        if(lastNode==null){ //가장 첫번째 노드(head)를 지워야 하는 경우
            return head.next;
        }

        while (lastNode.next!=null){
            lastNode=lastNode.next;
            targetNode=targetNode.next;
        }
        targetNode.next=targetNode.next.next;
        return head;
    }
}