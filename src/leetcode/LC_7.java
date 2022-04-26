package leetcode;
//https://leetcode.com/problems/reverse-integer/

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LC_7 {
    public static void main(String[] args) {
        Solution_7 s = new Solution_7();
        System.out.println(s.reverse(-2147483648));
    }
}

class Solution_7 {
    public int reverse(int x) {
        if(x ==Integer.MIN_VALUE)
            return 0;

        int absx = Math.abs(x);
        StringBuilder sign = x < 0 ? new StringBuilder("-") : new StringBuilder("");
        String stringx = Integer.toString(absx);
        StringBuilder reverseInt = new StringBuilder();

        for (int i = stringx.length() - 1; i >= 0; i--) {
            reverseInt.append(stringx.charAt(i));
        }

        // make edge
        String maxIntStr = Integer.toString(Integer.MAX_VALUE);

        // edge check
        if (reverseInt.length() == 10) {
            for (int i = 0; i < maxIntStr.length(); i++) {
                int outInd = reverseInt.charAt(i) - '0';
                int maxIntInd = maxIntStr.charAt(i) - '0';
                if (i == maxIntStr.length() - 1 && x < 0) {
                    if (outInd > maxIntInd + 1)
                        return 0;
                    else
                        break;
                }

                if (outInd < maxIntInd)
                    break;
                else if (outInd > maxIntInd)
                    return 0;
            }
        }

        if (x < 0) {
            reverseInt.insert(0, "-");
        }
        int out = Integer.parseInt(reverseInt.toString());
        return out;

    }
}

/*
class Solution {
    public int reverse(int x) {
       double ans =  0;
    while(x!=0){

     double rem = x%10;
     ans = ans*10+rem;
     if(ans >=Integer.MAX_VALUE || ans<=Integer.MIN_VALUE ) return 0;
        x =x/10;

    }
    return (int) ans;

    }
}
 */
