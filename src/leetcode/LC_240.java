package leetcode;

public class LC_240 {
}

class Solution_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;

        while ((0 <= row && row < matrix.length) &&
                (0 <= col && col < matrix[0].length)) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                row++;
            else
                col--;
        }
        return false;
    }
}