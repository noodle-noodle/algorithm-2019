package tiling2_8;

import java.util.Scanner;

public class Somin {

    public static void main(String[] args) {
        int DIVIDE_NUMBER = 1000000007;
        int[] caseCount = new int[1000001];
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        caseCount[1] = 1;
        caseCount[2] = 2;

        for (int i = 0; i < testCaseCount; i++) {
            int height = scanner.nextInt();

            for (int j = 3; j <= height; j++) {
                if (caseCount[j] == 0) {
                    caseCount[j] = (caseCount[j - 1] + caseCount[j - 2]) % DIVIDE_NUMBER;
                }
            }
            System.out.println(caseCount[height]);
        }
    }
}