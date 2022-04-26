package leetcode;

public class LC_11 {
    public static void main(String[] args) {
        int [] array={4,7,4,5,8,6};
        System.out.println(Solution.maxArea(array));
    }
    /*
    static class Solution {
        public static int maxArea(int[] height) {
            int result=0;
            int min_height=0;
            for (int i = 0; i < height.length; i++) {
                for (int j = 0; j <i ; j++) {
                    min_height=Math.min(height[i],height[j]);
                    result=Math.max(result,min_height*(i-j));
                }
            }
            return result;
        }
    }

    */
    static class Solution {
        public static int maxArea(int[] height) {
            int result=0,left=0,right=height.length-1;
            while (right-left>0){
                result =Math.max(result,(right-left)*Math.min(height[right],height[left]));

                if(height[right]<=height[left])
                    right--;
                else
                    left++;
            }

            return result;
        }
    }
}


