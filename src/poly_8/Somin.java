package poly_8;

import java.util.Scanner;

public class Somin {
    private static final int DIVIDE_NUMBER = 10000000;
    private static long[][] polyominoCounts;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        polyominoCounts = new long[101][101];
        polyominoCounts[1][1] = 1;
        polyominoCounts[1][2] = 1;
        polyominoCounts[2][2] = 1;

        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            int squareNumber = scanner.nextInt();
            long result = 0;

            for (int i = 1; i <= squareNumber; i++) {
                result += getPolyominoCount(i, squareNumber) % DIVIDE_NUMBER;
            }

            System.out.println(result % DIVIDE_NUMBER);
        }
    }

    private static long getPolyominoCount(int first, int squareNumber) {
        long result = 0;
        int newSquareNumber = squareNumber - first;

        for (int second = 1; second <= newSquareNumber; second++) {
            if (polyominoCounts[second][newSquareNumber] == 0) {
                polyominoCounts[second][newSquareNumber] = getPolyominoCount(second, newSquareNumber);
            }
            result += polyominoCounts[second][newSquareNumber] * (first + second - 1) % DIVIDE_NUMBER;
        }

        if (first == squareNumber) {
            result = 1;
        }

        return result;
    }

    private static void printPoly(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(polyominoCounts[i][j]+"\t\t");
            }
            System.out.println();
        }
    }
}
