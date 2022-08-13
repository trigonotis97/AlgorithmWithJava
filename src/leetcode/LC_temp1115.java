package leetcode;


public class LC_temp1115 {
    public static void main(String[] args) {
        Solution_prog_2 s = new Solution_prog_2();

        System.out.println(s.solution("EIOU"));
    }
}

 class Solution_prog_2 {
//https://irontech.tistory.com/56

    char[] aeiou = {'A', 'E', 'I', 'O', 'U'};
    int count = 0;
    boolean isStop = false;

    public int solution(String word) {
        dfs(0, "", word);
        return count;
    }

    public void dfs(int depth, String next, String target) {
        if (depth == 6) return;

        if (next.equals(target)) {// 찾으려는 숫자가 맞을경우
            isStop = true;
            return;
        }

        for (int i = 0; i < 5; i++) { //직접 카운트하기
            if (isStop) return;

            if (depth + 1 < 6) count++; //이번 회차가 아닌 다음 dfs로 보내지는 단어를 카운트함.
            dfs(depth + 1, next + aeiou[i], target);

        }
    }
}