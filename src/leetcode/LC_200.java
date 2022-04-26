package leetcode;

public class LC_200 {
}

class Solution_200 {
    char[][] grid;
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (this.grid[i][j]=='1') {
                    count++;
                    findIsland(i, j);
                }
            }
        }
        return count;
    }
    void findIsland(int y, int x) {
        grid[y][x] = '0';
        int y1;
        int x1;
        for (int i = 0; i < 4; i++) {
            y1 = y + dir[i][0];
            x1 = x + dir[i][1];
            if((0<=y1 && y1<grid.length)&&(0<=x1 && x1 <grid[0].length))
                if(grid[y+dir[i][0]][x+dir[i][1]]=='1')
                    findIsland(y+dir[i][0],x+dir[i][1]);
        }
    }
}