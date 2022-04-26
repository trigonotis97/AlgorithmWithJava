package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC_36 {
    public static void main(String[] args) {
        System.out.println(new Solution_36().isValidSudoku(new char[][]
                {{'7','.','.','.','4','.','.','.','.'},{'.','.','.','8','6','5','.','.','.'},{'.','1','.','2','.','.','.','.','.'},{'.','.','.','.','.','9','.','.','.'},{'.','.','.','.','5','.','5','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','2','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}}
        ));
    }
}

class Solution_36 {
    public boolean isValidSudoku(char[][] board) {

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                //check square
                if(i%3==0&&j%3==0) {
                    set = new HashSet<>();
                    for (int n = i; n < i + 3; n++) {
                        for (int k = j; k < j + 3; k++) {
                            if (board[n][k] != '.') {
                                if (!set.add(board[n][k])) return false;
                            }
                        }
                    }
                }


                //check col
                if (j == 0) {
                    set = new HashSet<>();
                    for (int k = 0; k < board.length; k++) {
                        if (board[i][k] != '.') {
                            if (!set.add(board[i][k])) return false;
                        }
                    }
                }
                //check row
                if (i == 0) {
                    set = new HashSet<>();
                    for (int k = 0; k < board.length; k++) {
                        if (board[k][j] != '.') {
                            if (!set.add(board[k][j])) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
