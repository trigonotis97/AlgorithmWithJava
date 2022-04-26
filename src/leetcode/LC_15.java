package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LC_15 {
    public static void main(String[] args) {
        Solution_15 s = new Solution_15();
        System.out.println(s.threeSum(new int []{-1,0,1,2,-1,-4}));
    }
}

class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outList = new ArrayList<>();

        Arrays.sort(nums);
        int front,back,sum;
        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]) // num[i] 가 이전 숫자와 같을경우 패스
                continue;
            front=i+1;
            back=nums.length-1;
            while (front<back){
                sum = nums[i] + nums[front] + nums[back];

                if(sum<0) front++;
                else if(sum>0) back--;

                else {
                    outList.add((List.of(nums[i] , nums[front] , nums[back])));
                    //다음 번의 front 와 back이 가리키는 숫자가 이전과 같을 경우 제외시키기
                    while (nums.length>front+1 && nums[front]==nums[front+1]) {
                        front++;
                    }
                    while (back-1>=0 && nums[back]==nums[back-1]) {
                        back--;
                    }
                    front++;
                    back--;
                }

            }
        }
        return outList;
    }
}


