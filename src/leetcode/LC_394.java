package leetcode;

public class LC_394 {
    public static void main(String[] args) {
        System.out.println(new Solution_394().decodeString("100[leetcode]"));
    }


}

class Solution_394 {
    public String decodeString(String s) {
        StringBuilder output= new StringBuilder();

        for (int t = 0; t < s.length() ; t++) {
            char c= s.charAt(t);
            if(c>='0'&&c<='9'){
                StringBuilder num=new StringBuilder();
                num.append(c);
                t++;
                for (char j=s.charAt(t); j>='0'&&j<='9'; t++,j=s.charAt(t)) {
                    num.append(j);
                }
                int open=0 ,close=0,i;
                for (i = t; i <s.length() ; i++) {
                    if(s.charAt(i)=='[')
                        open++;
                    else if(s.charAt(i)==']')
                        close++;
                    if(open==close) {
                        break;
                    }
                }
                output.append(decodeString(s.substring(t+1, i)).repeat(Integer.parseInt(num.toString())));
                t=i;
            }
            else {
                output.append(c);
            }
        }
        return output.toString();
    }


}