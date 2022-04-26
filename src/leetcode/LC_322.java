package leetcode;

public class LC_322 {
    public static void main(String[] args) {
        Solution_322 s = new Solution_322();
        System.out.println(s.coinChange(new int[] {186,419,83,408},6249));
    }

}

class Solution_322 {
    public int coinChange(int[] coins, int amount) {
        int[] DP = new int[amount + 1];
        for (int i = 1; i <=amount ; i++) {
            DP[i]=amount+1; //Integer.MAX 대신 사용.
            for (int coin : coins) {
                if(i-coin>=0)
                    DP[i]=Math.min(DP[i],DP[i-coin]+1);
            }
        }
        return DP[amount]>amount? -1 : DP[amount];
    }
}
