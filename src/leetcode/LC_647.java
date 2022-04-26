package leetcode;

public class LC_647 {
    public static void main(String[] args) {
        Solution_647 s = new Solution_647();
        System.out.println(s.countSubstrings("abcb"));
    }
}



class Solution_647 {
    public int countSubstrings(String s) {
        int count=0;
        for (int i = 0; i <s.length() ; i++) {
            for (int end=i+1 ; end<s.length() ; end++) {
                int front=i,back=end;
                while (s.charAt(front)==s.charAt(back)){
                    front++;
                    back--;
                    if(front>=back) {
                        count++;
                        break;
                    }
                }
            }

        }

        return count+s.length();
    }
}
