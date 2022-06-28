package leetcode;

public class LC_29 {
    public static void main(String[] args) {
        System.out.println(new Solution_29().divide(-2147483648
                , 1));
    }
}

class Solution_29 {
    public int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE)
            return 0;

        int d=divisor;
        int count = 0;
        int sign = 1;
        int dividendSign = 1;
        if (dividend < 0) dividendSign = -1;
        if ((dividend < 0 && divisor > 0) || (divisor < 0 && dividend > 0)) {
            sign = -1;
            d = -d;
        }
        if(dividend == Integer.MIN_VALUE  && divisor==-1){
            return Integer.MAX_VALUE;
        }
        if (divisor == 1 || divisor == -1) {
            if (sign == dividendSign) return dividend;
            else return -dividend;
        }

        while (!(dividendSign == -1 && dividend - d > 0) &&
                !(dividendSign == 1 && dividend - d < 0)) {
            dividend -= d;
            count++;
        }

        if (sign < 0) return -count;
        else return count;

    }
}

class Solution_29_2 {
    public int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE)
            return 0;

        int count = 0;
        int sign = 1;
        int dividendSign = 1;
        if (dividend < 0) dividendSign = -1;
        if ((dividend < 0 && divisor > 0) || (divisor < 0 && dividend > 0)) {
            sign = -1;
            divisor = -divisor;
        }
        if(dividend == Integer.MIN_VALUE  && divisor==-1){
            return Integer.MAX_VALUE;
        }
        if (divisor == 1 || divisor == -1) {
            if (sign == dividendSign) return dividend;
            else return -dividend;
        }

        while (!(dividendSign == -1 && dividend - divisor > 0) &&
                !(dividendSign == 1 && dividend - divisor < 0)) {
            //            if (dividendSign == -1 && dividend - divisor > 0)
            //                break;
            //            else if (dividendSign == 1 && dividend - divisor < 0)
            //                break;
            dividend -= divisor;
            count++;
        }

        if (sign < 0) return -count;
        else return count;

    }
}
