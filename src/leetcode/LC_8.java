package leetcode;

//https://leetcode.com/problems/string-to-integer-atoi/
public class LC_8 {
    public static void main(String[] args) {
        Solution_8 s = new Solution_8();
        System.out.println(s.myAtoi("  0000000000012345678"));
    }
}

class Solution_8 {
    public int myAtoi(String s) {
        int out;

        //without flag
        int i = 0;
        StringBuilder sb = new StringBuilder();
        String sign = "";
        char c;

        //find digit start
        for (; i < s.length(); i++) {
            c = s.charAt(i);

            if (c >= '0' && c <= '9') break;
            else if (c == '-' || c == '+') {
                sign = String.valueOf(c);
                i++;
                break;
            }
            else if(c ==' ') continue;
            else return 0;
        }
        //ignore front zero
        for (; i < s.length(); i++){
            if(s.charAt(i)!='0') break;
        }

        //find digit end
        for (; i < s.length(); i++) {
            c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                break;
            }
        }

        //check edge case
        //sb.insert(0, sign);
        if (sb.length() > 10) {
            if (sign.equals("-")) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        } else if (sb.length() == 10) {
            sb.insert(0, sign);
            long intCheck = Long.parseLong(sb.toString());
            if (intCheck > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (intCheck < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        } else if (sb.length() == 0) {
            return 0;
        } else {
            sb.insert(0, sign);
        }

        out = Integer.parseInt(sb.toString());
        return out;




    }
}
