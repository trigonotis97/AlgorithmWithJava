package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1991 {
    static Map<String, ArrayList<String>> listMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String key;
        ArrayList<String> childList;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            key = st.nextToken();
            childList = new ArrayList<>();
            childList.add(st.nextToken());
            childList.add(st.nextToken());
            listMap.put(key, childList);
        }
        traversal("A", -1);
        System.out.println();
        traversal("A", 0);
        System.out.println();
        traversal("A", 1);
    }

    static void traversal(String root, int order) {
        if (order == -1) System.out.print(root);
        if (!listMap.get(root).get(0).equals(".")) {
            traversal(listMap.get(root).get(0), order);
        }
        if (order == 0) System.out.print(root);
        if (!listMap.get(root).get(1).equals(".")) {
            traversal(listMap.get(root).get(1), order);
        }
        if (order == 1) System.out.print(root);
    }
}
