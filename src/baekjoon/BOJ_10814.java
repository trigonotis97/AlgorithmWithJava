package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int h = Integer.parseInt(br.readLine());
        List<User> userList = new ArrayList<>();
        String[] tmp;
        for (int i = 0; i < h; i++) {
            tmp = br.readLine().split(" ");
            userList.add(new User(Integer.parseInt(tmp[0]), tmp[1]));
        }
        Collections.sort(userList);
        for (int i = 0; i < h; i++) System.out.println(userList.get(i).age + " " + userList.get(i).name);

    }

    static class User implements Comparable<User> {
        public static int generateValue = 0;
        public int age;
        public String name;
        public int order;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
            order = generateValue++;
        }

        @Override
        public int compareTo(User o) {
            if (this.age == o.age) {
                return this.order > o.order ? 1 : -1;
            }
            return this.age > o.age ? 1 : -1;
        }
    }
}
