package leetcode;

public class LC_79 {
    public static void main(String[] args) {
        Solution_79 s = new Solution_79();
        System.out.println(s.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}},"ABCEFSADEESE"));
        //System.out.println(s.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCEFSADEESE"));
        //System.out.println(s.exist(new char[][] {{'a','a'}},"aaa"));
    }
}

class Solution_79 {
    int[][] dist = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean out = false;
    char[][] board;
    public boolean exist(char[][] board, String word) {
        this.board=board;
        int[][] dist = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i, j;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visits = new boolean[board.length][board[0].length] ;
                    visits[i][j]=true;
                    recursion(visits, word, i, j,1);
                }
            }
        }
        return out;
    }

    void recursion(boolean[][] visits, String word, int y, int x,int ind) {
        if(ind==word.length()){
            out=true;
            return;
        }
        char wordChar = word.charAt(ind);
        for (int l = 0; l < 4; l++) {
            int y1=y+dist[l][0];
            int x1=x+dist[l][1];
            if ((y1<board.length&&y1>=0)&&(x1<board[0].length&&x1>=0)) {
                if(board[y1][x1]==wordChar &&!visits[y1][x1]) {
                    visits[y1][x1] = true;
                    recursion(visits, word, y1, x1, ind + 1);
                    visits[y1][x1] = false;
                }
            }
        }
    }
}
