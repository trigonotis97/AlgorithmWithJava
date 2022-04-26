package leetcode;

import java.util.*;

public class LC_142 {
    public static void main(String[] args) {
        System.out.println(String.format("%10s", "1000000"));
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//출처 : https://www.youtube.com/watch?v=SPKJz8oPJo4&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=33
class Solution_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode walker=head;
        ListNode runner=head;
        while (runner!=null){ //루프가 없을경우 탈출
            runner = runner.next;
            if(runner!=null){
                runner=runner.next; //러너는 달리는 사람이라 두번 움직임
                walker=walker.next;
                if(walker==runner){
                    break;
                }
            }
            else { //runner가 null일경우 루프가 없으므로 탈출
                break;
            }
        }

        if(runner==null) // 루프가 없는경우 최종 null 반환
            return null;

        ListNode check = head;
        while (check!=walker){
            check=check.next;
            walker=walker.next;
        }
        return check;
    }
}


class Solution_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> out= new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int size= queue.size();

            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur == null) break;

                if(i == size - 1) out.add(cur.val);

                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }

        return out;
    }
}
class Solution_148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        Collections.sort(list, Collections.reverseOrder());

        ListNode out = new ListNode(list.get(0));
        for(int i=1; i< list.size(); i++){
            out = new ListNode(list.get(i), out);
        }

        return out;
    }
}



class Solution_201 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] topology = new int[numCourses];  //위상 저장 배열
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<numCourses; i++) { //prerequisites 정렬용 List 생성
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) { //선수강이 필요한 과목이 있으면 위상 증가
            int x = prerequisite[0];
            int y = prerequisite[1];
            topology[x]++;
            graph.get(y).add(x); //list 에 prerequisites **값 넣음 (인덱스가 과목, 해당 인덱스의 리스트가 선수강과목)**
        }

        int count = 0;
        while (count < numCourses) {
            boolean courseTaken = false;
            for (int i = 0; i < numCourses; i++) { //graph 리스트를 돌면서
                if (topology[i] == 0) {
                    List<Integer> list = graph.get(i);
                    for (Integer x : list) {
                        topology[x]--;
                    }

                    topology[i]--;
                    courseTaken = true;
                    count++;
                }
            }
            if (!courseTaken) break;
        }

        return count == numCourses;
    }
}


class Solution_ {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] topology = new int[numCourses];  //위상 저장 배열
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<numCourses; i++) { //prerequisites 정렬용 List 생성
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) { //선수강이 필요한 과목이 있으면 위상 증가
            int x = prerequisite[0];
            int y = prerequisite[1];
            topology[x]++;
            graph.get(y).add(x); //list 에 prerequisites 값 넣음 (인덱스가 과목, 해당 인덱스의 리스트는 후수강과목 )
        }

        int count = 0;
        while (count < numCourses) { //과목 수만큼 반복
            boolean courseTaken = false;
            for (int i = 0; i < numCourses; i++) { //topology 배열을 돌면서
                if (topology[i] == 0) { //위상이 0인 과목 수강 (선수강강의가 없는과목)
                    List<Integer> list = graph.get(i); //해당과목의 선수강이 필요한 과목을 찾아
                    for (Integer x : list) {
                        topology[x]--; //위상을 1씩 감소
                    }

                    topology[i]--; //-1로 만들어 중복 탐색 제거
                    courseTaken = true;
                    count++; //과목 수만큼 반복
                }
            }
            if (!courseTaken) break; //더이상 들을 수 있는 선수강과목이 없는 과목이 없으면 탈출
        }

        return count == numCourses;
    }
}
