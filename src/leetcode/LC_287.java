package leetcode;

public class LC_287 {
    public static void main(String[] args) {
        Solution_287 s = new Solution_287();
        System.out.println(s.findDuplicate(new int[] {1,3,4,2,2}));
    }
}
class Solution_287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[slow]];
        } while (slow != fast);

        slow = nums[0];
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}