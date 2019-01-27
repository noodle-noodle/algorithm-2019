package trianglepath_8;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Somin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            int triangleSize = scanner.nextInt();
            int arraySize = triangleSize + 1;
            int[][] triangle = new int[arraySize][arraySize];
            int[][] answer = new int[arraySize][arraySize];


            for (int j = 1; j < arraySize; j++) {
                for (int k = 1; k <= j; k++) {
                    triangle[j][k] = scanner.nextInt();
                }
            }

            for (int j = 1; j < arraySize; j++) {
                for (int k = 1; k <= j; k++) {
                    if (j == 1 && k == 1) {
                        answer[j][k] = triangle[j][k];
                    } else {
                        answer[j][k] = getBiggerSum(triangle[j][k], answer[j - 1][k], answer[j - 1][k - 1]);
                    }
                }
            }

            Arrays.sort(answer[triangleSize]);
            System.out.println(answer[triangleSize][triangleSize]);

        }
    }

    private static int getBiggerSum(int target, int upper, int upperLeft) {
        int upperSum = upper + target;
        int upperLeftSum = upperLeft + target;

        return Math.max(upperSum, upperLeftSum);
    }
}