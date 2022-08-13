package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_46 {
    public static void main(String[] args) {
        Solution_46 s =new Solution_46();
        int [] arr ={1,2,3};
        System.out.println(s.permute(arr).toString());
    }
}
class Solution_46 {
    List<List<Integer>> output;

    {
        output=new ArrayList<>();
    }
    public List<List<Integer>> permute(int[] nums) {

        if(nums.length==1){
            List<Integer> new_list=new ArrayList<>();
            new_list.add(nums[0]);
            output.add(new_list);
            return output;
        }



        List<Integer> numList=new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        recursion(new ArrayList<Integer>(),numList);
        return output;
    }
    void recursion(List<Integer> list,List<Integer> numList){
        if(numList.size()==1){
            list.add(numList.get(0));
            output.add(list);
            return;
        }

        for (int i = 0; i < numList.size(); i++) {
            List<Integer> new_numList=new ArrayList<>(numList);
            new_numList.remove(i);
            List<Integer> new_list=new ArrayList<>(list);
            new_list.add(numList.get(i));
            recursion(new_list,new_numList);
        }
    }
}
/*
46. Permutations
Medium

7771

154

Add to List

Share
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */