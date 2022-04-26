package leetcode;

public class LC_5 {
    public static void main(String[] args) {
        Solution_5 s = new Solution_5();
        System.out.println(s.longestPalindrome("abcb"));
    }}

class Solution_5 {
    public String longestPalindrome(String s) {
        String out=s.substring(0,1);
        for (int i = 0; i <s.length() ; i++) {
            for (int end=i+1 ; end<s.length() ; end++) {
                if(out.length()>(end+1-i))
                    continue;
                int front=i,back=end;
                while (s.charAt(front)==s.charAt(back)){
                    front++;
                    back--;
                    if(front>=back) {
                        if(out.length()<s.substring(i,end+1).length())
                            out=s.substring(i,end+1);
                        break;
                    }
                }
            }

        }

        return out;
    }
}
