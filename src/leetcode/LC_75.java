package leetcode;

public class LC_75 {
}

class Solution_75 {
    public void sortColors(int[] nums) {
        int front = 0, back = nums.length - 1, tmp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (front == i) front++;
                else {
                    tmp = nums[i];
                    nums[i] = nums[front];
                    nums[front] = tmp;
                    front++;
                }
            } else if (nums[i] == 2) {
                if (back == i) break;
                else {
                    tmp = nums[i];
                    nums[i] = nums[back];
                    nums[back] = tmp;
                    back--;
                    i--;

                }

            }
            if (i >= back)
                break;
        }

    }
}