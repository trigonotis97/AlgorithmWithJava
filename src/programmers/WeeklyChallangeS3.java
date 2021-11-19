package programmers;

import java.util.ArrayList;
import java.util.List;

public class WeeklyChallangeS3 {
}

//빛의경로 사이클
//https://jisunshine.tistory.com/175
class Solution_86952 {
    int R, C;
    int[] dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1};
    boolean[][][] visits;

    public int[] solution(String[] grid) {

        List<Integer> out = new ArrayList<>();
        R = grid.length;
        C = grid[0].length();

        visits = new boolean[R][C][4];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!visits[i][j][k]) {
                        out.add(dfs(grid, i, j, k));
                    }
                }
            }
        }
        return out.stream().sorted().mapToInt(e -> e).toArray();
    }

    int dfs(String[] grid, int r, int c, int d) {
        int cnt = 0;
        while (!visits[r][c][d]) {
            cnt++;
            visits[r][c][d] = true;
            if (grid[r].charAt(c) == 'L')
                d = d == 0 ? 3 : d - 1;
            else if (grid[r].charAt(c) == 'R')
                d = d == 3 ? 0 : d + 1;

            r = (r + dr[d] + R) % R;
            c = (c + dc[d] + C) % C;
        }
        return cnt;
    }
}
//나머지가 1이 되는 수 찾기
class Solution_87389 {
    public int solution(int n) {
        int i=1;
        for (; i < n; i++) {
            if(n%i==1)
                break;
        }
        return i;
    }
}