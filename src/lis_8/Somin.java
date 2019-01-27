package lis_8;

import java.util.Scanner;

public class Somin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            int sequenceLength = scanner.nextInt();
            int[] sequence = new int[sequenceLength];
            int subsequenceLength = 1;

            for (int j = 0; j < sequenceLength; j++) {
                sequence[j] = scanner.nextInt();
            }

            for (int j = 1; j < sequenceLength; j++) {
                if (sequence[j - 1] < sequence[j]) {
                    subsequenceLength++;
                } else {
                    subsequenceLength = 1;
                }
            }

            System.out.println(subsequenceLength);
        }
    }

}
