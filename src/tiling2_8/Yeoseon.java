package tiling2_8;

import java.util.Scanner;

public class Yeoseon {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int executeNum = sc.nextInt();

        for (int i = 0; i < executeNum; i++) {
            int n = sc.nextInt();
            int[] d = new int[100];

            d[0] = 1;
            d[1] = 2;

            for (int j = 2; j < n; j++) {
                d[j] = (d[j - 1] + d[j - 2]) % 1000000007;
            }
            System.out.println(d[n - 1]);
        }
    }
}
