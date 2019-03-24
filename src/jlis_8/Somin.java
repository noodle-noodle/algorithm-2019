package jlis_8;

import java.util.*;

public class Somin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            int firstSequenceLength = scanner.nextInt();
            int secondSequenceLength = scanner.nextInt();

            List<Integer> firstSequence = new ArrayList<Integer>();
            List<Integer> secondSequence = new ArrayList<Integer>();

            for (int i = 0; i < firstSequenceLength; i++) {
                Integer num = scanner.nextInt();

                if (!firstSequence.contains(num)) {
                    firstSequence.add(num);
                }
            }

            for (int i = 0; i < secondSequenceLength; i++) {
                Integer num = scanner.nextInt();

                if (!firstSequence.contains(num) && !secondSequence.contains(num)) {
                    secondSequence.add(num);
                }
            }

            int firstSequenceValidLength = firstSequence.size();
            int secondSequenceValidLength = secondSequence.size();

            int[] firstMaxLength = new int[firstSequenceValidLength];
            int[] secondMaxLength = new int[secondSequenceValidLength];

            for (int j = 1; j < firstSequenceValidLength; j++) {
                for (int k = 0; k < j; k++) {
                    if (firstSequence.get(k) < firstSequence.get(j) && firstMaxLength[k] + 1 > firstMaxLength[j]) {
                        firstMaxLength[j] = firstMaxLength[k] + 1;
                    }
                }
            }

            for (int j = 1; j < secondSequenceValidLength; j++) {
                for (int k = 0; k < j; k++) {
                    if (secondSequence.get(k) < secondSequence.get(j) && secondMaxLength[k] + 1 > secondMaxLength[j]) {
                        secondMaxLength[j] = secondMaxLength[k] + 1;
                    }
                }
            }

            Arrays.sort(firstMaxLength);
            Arrays.sort(secondMaxLength);

            System.out.println(firstMaxLength[firstSequenceValidLength - 1] + secondMaxLength[secondSequenceValidLength - 1] + 2);
        }
    }
}
