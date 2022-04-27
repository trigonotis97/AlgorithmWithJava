package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC_73 {
}

class Solution_73 {
    public void setZeroes(int[][] matrix) {
        Set<Point> stack = new HashSet<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) stack.add(new Point(i, j));
            }
        }
        for (Point p : stack) {
            for (int i = 0; i < rows; i++) {
                if (matrix[i][p.x] != 0) matrix[i][p.x] = 0;
            }
            for (int i = 0; i < cols; i++) {
                if (matrix[p.y][i] != 0) matrix[p.y][i] = 0;
            }
        }
    }

    class Point {
        int y;
        int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
