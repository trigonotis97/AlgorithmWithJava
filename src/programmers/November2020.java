package programmers;

import java.util.Arrays;
import java.util.Vector;

public class November2020 {
    public static void main(String[] args) {
        Solution2 s =new Solution2();
        System.out.println(Arrays.toString(s.solution("1111111")));
    }
}

class Solution1 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer+=a[i]*b[i];
        }

        return answer;
    }
}
class Solution2 {
    public int[] solution(String s) {
        int[] answer = {0,0};
        int zeroCnt = 0;
        int bineryCnt=0;
        while (s.compareTo("1")!=0){
            bineryCnt++;

            //0제거
            String res = "";
            int currentLength=s.length();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    res.concat("1");
                }
                else{
                    zeroCnt++;
                    currentLength--;
                }
            }
            // 제거후 길이 이진변환
            s=Integer.toBinaryString(currentLength);
        }
        answer[0]=bineryCnt;
        answer[1]=zeroCnt;
        return answer;

    }



}
