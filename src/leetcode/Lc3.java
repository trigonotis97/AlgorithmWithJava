package leetcode;

public class Lc3 {
    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLongestSubstring("~"));

    }

    static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            boolean []alphabet=new boolean[95];
            int result=0;
            int count=0;
            int t=32;
            int front_ind=0;
            if(s.length()>0) {
                alphabet[(int)s.charAt(0)-t]=true;
                result=count=1;
            }
            for (int i = 1; i < s.length(); i++) {

                if(!alphabet[(int) s.charAt(i) - t]) {
                    alphabet[(int) s.charAt(i) - t] = true;
                    count++;
                    result = Math.max(result,count);
                }
                else{
                    do{
                        if(s.charAt(i)!=s.charAt(front_ind)) {
                            alphabet[(int) s.charAt(front_ind) - t] = false;
                            count--;
                            front_ind++;
                        }
                        else{
                            front_ind++;
                            break;
                        }
                    }while (true);
                }

            }

            return result;
        }
    }
}
