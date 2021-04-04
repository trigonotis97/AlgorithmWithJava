package baekjoon.warmup;

import java.util.Scanner;

public class BOJ_2439 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int cnt= scanner.nextInt();

        for(int i=1;i<=cnt;i++){
            for(int j=0;j<cnt-i;j++)
                System.out.print(" ");
            for(int j=0;j<i;j++)
                System.out.print("*");
            System.out.print("\n");
        }
        scanner.close();
    }
}
