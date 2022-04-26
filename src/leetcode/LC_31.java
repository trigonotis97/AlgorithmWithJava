package leetcode;

import java.util.Arrays;

public class LC_31 {
    public static void main(String[] args) {
        Solution_31 s = new Solution_31();
        s.nextPermutation(new int[]{1, 3, 2});

    }
}

class Solution_31 {
    public void nextPermutation(int[] nums) {
        boolean maxNumFlag=true;
        int i;
        for (i = nums.length-2; i >=0 ; i--) { //뒤에서 한칸 앞 인덱스에서 시작
            if(nums[i]<nums[i+1]){
                maxNumFlag=false;
                break;
            }
        }
        if(maxNumFlag){
            Arrays.sort(nums);
        }
        else{
            int secondInd=200 ;//num 의 길이는 최대 100이므로 나올수 없는 수로 설정
            int diff=Integer.MAX_VALUE;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]>nums[i] && (nums[j]-nums[i])<diff){
                    diff=nums[j]-nums[i];
                    secondInd=j;
                }
            }
            int temp = nums[secondInd];
            nums[secondInd] = nums[i];
            nums[i] = temp;
            int [] array=Arrays.copyOfRange(nums,i+1,nums.length);
            Arrays.sort(array);
            for (int j = i+1; j < nums.length; j++) {
                nums[j]=array[j-i-1];
            }
        }
    }
}