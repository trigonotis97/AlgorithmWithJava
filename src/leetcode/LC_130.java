package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC_130 {
    public static void main(String[] args) {

        //   System.out.println(Arrays.deepToString(new Solution_130_2().solve(new char[][]{{'O', 'O'}, {'O', 'O'}})));
        System.out.println(Arrays.deepToString(new Solution_130_5().solve(new char[][]
                {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}})));
    }
}

class Solution_130 {
    char[][] storedBorad;
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public char[][] solve(char[][] board) {
        storedBorad = board;
        int rows = board.length;
        int cols = board[0].length;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (storedBorad[y][x] == 'O') {
                    recursion(y, x, false);
                }
            }
        }
        //board = storedBorad;
        return storedBorad;
    }

    void recursion(int y, int x, boolean deleteFlag) {
        int dirY, dirX;
        for (int i = 0; i < 4; i++) {
            dirY = dir[i][0];
            dirX = dir[i][1];
            if (dirY + y < storedBorad.length && dirY + y >= 0 &&
                    dirX + x < storedBorad[0].length && dirX + x >= 0
                    && storedBorad[dirY + y][dirX + x] == 'O') {
                storedBorad[y][x] = 'X';
                recursion(dirY + y, dirX + x, true);
            }
        }
        if (deleteFlag) storedBorad[y][x] = 'X';
    }
}

class Solution_130_2 {

    public char[][] solve(char[][] board) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows = board.length;
        int cols = board[0].length;
        int[][] weightboard = new int[rows][cols];
        int dirY, dirX;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (board[y][x] == 'O') {
                    for (int i = 0; i < 4; i++) {
                        dirY = dir[i][0] + y;
                        dirX = dir[i][1] + x;
                        if (dirY < rows && dirY >= 0 &&
                                dirX < cols && dirX >= 0
                                && board[dirY][dirX] == 'O') {
                            weightboard[dirY][dirX]++;
                        }
                    }
                }
            }
        }

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (weightboard[y][x] % 2 == 1 && board[y][x] == 'O') board[y][x] = 'X';
            }
        }
        return board;

    }
}

class Solution_130_3 {

    public void solve(char[][] board) {

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows = board.length;
        int cols = board[0].length;
        int[][] weightboard = new int[rows][cols];
        int dirY, dirX;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (board[y][x] == 'O') {
                    for (int i = 0; i < 4; i++) {
                        dirY = dir[i][0] + y;
                        dirX = dir[i][1] + x;
                        if (dirY < rows && dirY >= 0 &&
                                dirX < cols && dirX >= 0
                                && board[dirY][dirX] == 'O') {
                            weightboard[dirY][dirX]++;
                        }
                    }
                }
            }
        }

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (weightboard[y][x] % 2 == 1 && board[y][x] == 'O') board[y][x] = 'X';
            }
        }

    }
}

class Solution_130_4 {

    public void solve(char[][] board) {

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows, cols;

        rows = board.length;
        cols = board[0].length;
        char[][] storeBoard = new char[rows][cols];

        int dirY, dirX, yy, xx;

        for (int i = 0; i < rows; i++) {
            storeBoard[i] = board[i].clone();
            Arrays.fill(board[i], 'X');
        }

        Queue<Integer> qy = new LinkedList<>();
        Queue<Integer> qx = new LinkedList<>();

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (storeBoard[y][x] == 'O') {
                    qy.offer(y);
                    qx.offer(x);
                    while (!qy.isEmpty()) {
                        yy = qy.poll();
                        xx = qx.poll();
                        board[yy][xx] = 'O';
                        storeBoard[yy][xx] = 'X';
                        for (int i = 0; i < 4; i++) {
                            dirY = dir[i][0] + yy;
                            dirX = dir[i][1] + xx;
                            if (dirY < rows && dirY >= 0 &&
                                    dirX < cols && dirX >= 0
                                    && storeBoard[dirY][dirX] == 'O') {
                                qy.offer(dirY);
                                qx.offer(dirX);
                            }
                        }
                    }
                }
                if (y > 0 && y < rows - 1 && x == 0) x = cols - 2;
            }
        }

    }
}

class Solution_130_5 {
    char[][] storeBoard;
    char[][] resultBoard;
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {

        //   System.out.println(Arrays.deepToString(new Solution_130_2().solve(new char[][]{{'O', 'O'}, {'O', 'O'}})));
        System.out.println(Arrays.deepToString(new Solution_130_5().solve(new char[][]
                {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}})));
    }
    public char[][] solve(char[][] board) {

        int rows, cols;

        rows = board.length;
        cols = board[0].length;
        storeBoard = new char[rows][cols];
        resultBoard = board;

        for (int i = 0; i < rows; i++) {
            storeBoard[i] = board[i].clone();
            Arrays.fill(resultBoard[i], 'X');
        }


        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (storeBoard[y][x] == 'O') {
                    recursion(y, x, rows, cols);
                }
                if (y > 0 && y < rows - 1 && x == 0) x = cols - 2;
            }
        }
        board = resultBoard;
        return board;
    }

    void recursion(int y, int x, int rows, int cols) {

        int dirY, dirX;
        resultBoard[y][x] = 'O'; //marking
        storeBoard[y][x] = 'X'; //delete
        for (int i = 0; i < 4; i++) {
            dirY = dir[i][0] + y;
            dirX = dir[i][1] + x;
            if (dirY < rows && dirY >= 0 &&
                    dirX < cols && dirX >= 0
                    && storeBoard[dirY][dirX] == 'O') {
                recursion(dirY, dirX, rows, cols);
            }
        }
    }
}




