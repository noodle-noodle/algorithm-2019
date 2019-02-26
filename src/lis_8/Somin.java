package lis_8;

import java.util.Arrays;
import java.util.Scanner;

public class Somin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            int sequenceLength = scanner.nextInt();
            int[] sequence = new int[sequenceLength];
            int[] maxLength = new int[sequenceLength];

            for (int j = 0; j < sequenceLength; j++) {
                sequence[j] = scanner.nextInt();
                maxLength[j] = 1;
            }

            for (int j = 1; j < sequenceLength; j++) {
                for (int k = 0; k < j; k++) {
                    if (sequence[k] < sequence[j] && maxLength[k] + 1 > maxLength[j]) {
                        maxLength[j] = maxLength[k] + 1;
                    }
                }
            }

            Arrays.sort(maxLength);
            System.out.println(maxLength[sequenceLength - 1]);
        }
    }
}
