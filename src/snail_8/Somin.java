package snail_8;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Somin {
    private static final double SUNNY_PROBABILITY = 0.25;
    private static final double RAINY_PROBABILITY = 0.75;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        double[][] impossibleProbability = new double[1001][1001];

        for (int i = 0; i < testCaseCount; i++) {
            int depth = scanner.nextInt();
            int rainySeasonLength = scanner.nextInt();
            NumberFormat formatter = new DecimalFormat("#0.0000000000");
            double probability = 1.0;

            if (depth <= rainySeasonLength) { // 모두 맑은 날이어도 올라갈 수 있음
                probability = 1.0;
            } else if (rainySeasonLength * 2 < depth) { // 모두 비가 오더라도 올라갈 수 없음
                probability = 0.0;
            } else if (depth / 2 == rainySeasonLength) { // 모두 비가 와야만 올라갈 수 있는 경우
                probability = Math.pow(RAINY_PROBABILITY, rainySeasonLength);
            } else { // 하루 이상 비가 오는 날
                for (int j = 1; j <= depth - rainySeasonLength; j++) {
                    double thisTimeImpossibility = Math.pow(SUNNY_PROBABILITY, rainySeasonLength - j + 1)
                            * Math.pow(RAINY_PROBABILITY, j - 1)
                            * combination(rainySeasonLength, j - 1);
                    impossibleProbability[j + rainySeasonLength][rainySeasonLength] = thisTimeImpossibility;
                    probability -= impossibleProbability[j + rainySeasonLength][rainySeasonLength];
                }
            }

            System.out.println(formatter.format(probability));
        }
    }

    public static int combination(int n, int r) {
        int result = 1;
        int divider = 1;

        for (int i = n; i > r; i--) {
            result *= i;
        }

        for (int i = n - r; i > 0; i--) {
            divider *= i;
        }

        return result / divider;
    }
}
