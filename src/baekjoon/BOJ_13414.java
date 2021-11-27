package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ_13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        String tmp;
        for (int i = 0; i < l; i++) {
            tmp = br.readLine();
            if (hashSet.contains(tmp)) hashSet.remove(tmp);
            hashSet.add(tmp);
        }
        for (String s : hashSet) {
            System.out.println(s);
            if (--k < 1) break;
        }
        br.close();
    }
}
