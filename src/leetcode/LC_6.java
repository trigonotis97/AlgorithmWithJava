package leetcode;

public class LC_6 {
    public static void main(String[] args) {
        Solution_6 s = new Solution_6();
        System.out.println(s.convert("ABCDE", 4));

    }

}

class Solution_6 {
    public String convert(String s, int numRows) {



        char[][] arr = new char[numRows][s.length()];
        int x = 0;
        int y = 0;
        int ind = 0;
        int dir = 1;
        while (ind < s.length()) {
            arr[y][x] = s.charAt(ind);

            y += dir;
            if (dir < 0) {
                x++;
            }
            ind++;
            if (y == numRows - 1) {
                dir = -1;
            } else if (y == 0) {
                dir = 1;
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '\u0000') {
                    continue;
                } else {
                    out.append(arr[i][j]);
                }
            }
        }
        return out.toString();
    }
}

