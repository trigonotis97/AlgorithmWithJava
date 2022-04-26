package leetcode;

public class LC_38 {
}

class Solution_38 {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String result = countAndSay(n - 1);
        StringBuilder out = new StringBuilder();
        char before = result.charAt(0);
        int count = 1;
        for (int i = 1; i < result.length(); i++) {
            if (before != result.charAt(i)) {
                out.append(count);
                out.append(before);
                before = result.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        out.append(count); // 마지막 값 넣어주기
        out.append(before);

        return out.toString();
    }

}
