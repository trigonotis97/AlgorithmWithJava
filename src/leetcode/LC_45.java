package leetcode;

public class LC_45 {
    public static void main(String[] args) {
        Solution_45 s =new Solution_45();
        System.out.println(s.jump(new int[]{2,3,1,1,4}));
    }
}

class Solution_45 {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int [] jumpCount=new int[nums.length]; //해당 인덱스에 도달할수있는 가장 적은 점프수 저장
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <nums[i]+1  ; j++) {
                if(j+i==nums.length-1) {
                    return jumpCount[i]+1;
                }
                else if(jumpCount[j+i]==0){
                    jumpCount[j+i]=jumpCount[i]+1;
                }
            }
        }
        return jumpCount[nums.length-1];
    }
}