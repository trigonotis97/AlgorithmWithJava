package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_39 {
    public static void main(String[] args) {
        int []arr={2,3,5};
        Solution_39 a =new Solution_39();
        System.out.println(a.combinationSum(arr,8).toString());



    }

}
class Solution_39 {
    int[] candidates;
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates=candidates;
        result=new ArrayList<>();
        recursion(new ArrayList<>(),target,0);
        return result;
    }

    void recursion(List<Integer> list, int num,int candi_ind){

        for (int i =candi_ind ; i <candidates.length ; i++) {
            //List<Integer> new_list=list;
            List<Integer> new_list=new ArrayList<>(list);
            if(num-candidates[i]==0){
                new_list.add(candidates[i]);
                result.add(new_list);
                return;
            }
            else if(num-candidates[i]>0){
                new_list.add(candidates[i]);
                recursion(new_list,num-candidates[i],i);
            }

        }
    }
}
