package leetcode;

public class LC_34 {
    public static void main(String[] args) {
        Solution_34 s = new Solution_34();
        System.out.println(s.searchRange(new int[]{2, 2}, 2));
    }
}

class Solution_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] out = new int[2];
        int st = 0;
        int en = nums.length - 1;
        int mid = (st + en) / 2;

        if (nums.length == 1 && nums[0] == target) {
            return out;
        }

        //앞부분 찾기
        while (st <= en) {
            if (nums[mid] == target) {

                if (mid == 0) break;
                else if (nums[mid - 1] != target) break;
                else en = mid - 1;

            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                en = mid - 1;
            }
            mid = (st + en) / 2;
        }
        if (st > en) {
            out[0] = out[1] = -1;
            return out;
        }
        out[0] = mid;
        st = mid;
        en = nums.length - 1;

        //뒷부분 찾기
        while (st <= en) {
            if (nums[mid] == target) {
                if (mid == nums.length - 1) break;
                if (nums[mid + 1] != target) break;
                else st = mid + 1;

            } else if (nums[mid] > target) {
                en = mid - 1;
            }
            mid = (st + en) / 2;
        }
        out[1] = mid;

        return out;
    }


}
