package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//done
public class BOJ_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Character[] farr = {'(', '['};
        Character[] barr = {')', ']'};

        while (true) {
            String line = br.readLine();
            boolean lineEnd = false;
            if (line.length() == 1 && line.equals(".")) { // 문제 끝
                break;
            }
            Deque<Character> queue = new LinkedList<>();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (Arrays.stream(farr).anyMatch(a -> a == c)) {
                    queue.add(c);
                } else if (Arrays.stream(barr).anyMatch(a -> a == c)) {
                    Character f = queue.pollLast();
                    if (f == null ||
                            (farr[0] == f && barr[0] != c) ||
                            (farr[1] == f && barr[1] != c) ){
                        System.out.println("no");
                        lineEnd = true;
                        break;
                    }
                }
            }
            if (lineEnd) {
                continue;
            }
            if (queue.size() > 0) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
    }

}
