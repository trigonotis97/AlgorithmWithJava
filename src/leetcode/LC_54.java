package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LC_54 {
    public static void main(String[] args) {
        System.out.println(new Solution_54().spiralOrder(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}

class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirInd = 0;
        int stack = 0;
        int y = 0;
        int x = 0;
        order.add(matrix[0][0]);
        matrix[0][0] = 101;
        while (true) {
            int dirx = dir[dirInd][1];
            int diry = dir[dirInd][0];

            if (y + diry == matrix.length || x + dirx == matrix[0].length ||
                    y + diry == -1 || x + dirx == -1 ||
                    matrix[y + diry][x + dirx] == 101) {
                dirInd++;
                stack++;
                if (stack == 4) {
                    return order;
                }
                if (dirInd == 4) {
                    dirInd = 0;
                }
            } else {
                y += diry;
                x += dirx;
                order.add(matrix[y][x]);
                stack = 0;
                matrix[y][x] = 101;
            }
        }
    }
}
