package jumpgame_8;

import java.util.Scanner;

public class Somin {
    private static int matrixSize;
    private static int[][] matrix;
    private static boolean[][] reachable;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            matrixSize = scanner.nextInt();
            matrix = new int[matrixSize][matrixSize];
            reachable = new boolean[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int column = 0; column < matrixSize; column++) {
                    matrix[row][column] = scanner.nextInt();
                    reachable[row][column] = false;
                }
            }

            setReachableSpot(0, 0);

            if (reachable[matrixSize - 1][matrixSize - 1]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void setReachableSpot(int row, int column) {
        if (row >= matrixSize || column >= matrixSize) {
            return;
        }

        if (row == matrixSize - 1 && column == matrixSize - 1) {
            return;
        }

        int distance = matrix[row][column];

        if (row + distance < matrixSize && !reachable[row + distance][column]) {
            reachable[row + distance][column] = true;
            setReachableSpot(row + distance, column);
        }

        if (column + distance < matrixSize && !reachable[row][column + distance]) {
            reachable[row][column + distance] = true;
            setReachableSpot(row, column + distance);
        }
    }
}
