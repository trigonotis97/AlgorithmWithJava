package leetcode;

import java.io.BufferedReader;
import java.util.Arrays;

public class LC_48 {
    public static void main(String[] args) {
        Solution_48 s = new Solution_48();
//        s.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        s.rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
    }
}

class Solution_48 {
    public void rotate(int[][] matrix)  {
        int temp;
        int l=matrix.length-1;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length-i-1; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[l  - j][i];
                matrix[l  - j][i] = matrix[l - i][l - j];
                matrix[l - i][l - j] = matrix[j][l - i];
                matrix[j][l - i] = temp;
            }
        }
    }


}
