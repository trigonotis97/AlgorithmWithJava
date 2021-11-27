package baekjoon;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_16165 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken()); //걸그룹의 수
        int m = Integer.parseInt(st.nextToken()); //맞혀야하는 문제 수

        HashMap<String, String> hsm = new HashMap<>(); //<팀이름,멤버이름목록>
        ArrayList<String> arr = new ArrayList<>();

        //걸그룹 팀 이름 저장
        for (int i = 0; i < n; i++) {
            String team = br.readLine(); // 팀이름
            int num = Integer.parseInt(br.readLine()); // 멤버수

            for (int j = 0; j < num; j++) {
                sb.append(br.readLine()).append(" ");
            }
            hsm.put(team, sb.toString());
            sb.setLength(0); //stringBuilder 초기화
        }

        //

        //문제관련 for문
        for(int i=0; i<m; i++) {
            String str = br.readLine(); //팀이름 또는 멤버이름 input
            int num = Integer.parseInt(br.readLine()); //퀴즈 숫자 입력 ( 0또는 1)
            arr.clear();

            //0의 입력이 들어왔을때 : 멤버이름 목록출력
            if(num == 0) {
                StringTokenizer st2 = new StringTokenizer(hsm.get(str)," ");
                while(st2.hasMoreTokens()) {
                    arr.add(st2.nextToken());
                }
                Collections.sort(arr); //정렬
                for(int j=0; j<arr.size();j++) {
                    bw.write(arr.get(j)+"\n");
                }
            }

            //1의 입력이 왔을때 : 해당 멤버의 팀이름 출력
            else {
                for (String key : hsm.keySet()) { // 해시맵 키값으로 전체 접근
                    StringTokenizer st3 = new StringTokenizer(hsm.get(key), " ");

                    while (st3.hasMoreTokens()) { // 키값으로 접근한 밸루에서 멤버이름 접근
                        String strr = st3.nextToken();
                        if (str.equals(strr)) {
                            bw.write(key + "\n");
                        }
                    }
                }
            }
        }

        bw.flush();
        bw.close();
    }

}


