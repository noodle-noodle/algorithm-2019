package tripathcnt_8;

import java.util.Scanner;

public class Yeoseon {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int length = sc.nextInt();
            int[][] triangle = new int[length][length];
            int[][] d = new int[length][length];
            int[][] cnt = new int[length][length];

            for (int j = 0; j < length; j++) {
                for (int k = 0; k <= j; k++) {
                    triangle[j][k] = sc.nextInt();
                }
            }


            for (int j = 0; j < length; j++) {
                for (int k = 0; k <= j; k++) {
                    if (j == 0) {
                        d[j][k] = triangle[j][k];
                        cnt[j][k] = 1;
                    } else {
                        if (k == 0) {
                            cnt[j][k] = cnt[j - 1][k];
                            d[j][k] = d[j - 1][k] + triangle[j][k];
                        } else {
                            if (d[j - 1][k] > d[j - 1][k - 1]) {
                                cnt[j][k] = cnt[j - 1][k];
                                d[j][k] = triangle[j][k] + d[j - 1][k];
                            } else if (d[j - 1][k] < d[j - 1][k - 1]) {
                                cnt[j][k] = cnt[j - 1][k - 1];
                                d[j][k] = triangle[j][k] + d[j - 1][k - 1];
                            } else {
                                cnt[j][k] = cnt[j - 1][k]+cnt[j-1][k-1];
                            }
                        }
                    }
                }
            }


            int max = 0;
            for (int j = 0; j < length; j++) {
                if (max < d[length - 1][j]) {
                    max = d[length - 1][j];
                }
            }

            int count = 0;
            for (int j = 0; j < length; j++) {
                if (max == d[length - 1][j]) {
                    count += cnt[length - 1][j];
                }
            }

            System.out.println(count);
        }
    }
}