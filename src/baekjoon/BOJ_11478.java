package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();


        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            String sub = "";
            for (int j = i; j < s.length(); j++) {
                sub+=s.substring(j,j+1);
                hs.add(sub);
            }
        }
        System.out.println(hs.size());
        br.close();

    }
}
