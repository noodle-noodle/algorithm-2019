package numb3rs_8;

import java.util.Scanner;

public class Somin {
    private static int[][] path;
    private static double[][] possibility;
    private static int[] connectedCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            int villageSize = scanner.nextInt();
            int passed = scanner.nextInt();
            int prison = scanner.nextInt();

            path = new int[villageSize][villageSize];
            possibility = new double[passed + 1][villageSize];
            connectedCount = new int[villageSize];

            for (int x = 0; x < villageSize; x++) {
                for (int y = 0; y < villageSize; y++) {
                    path[x][y] = scanner.nextInt();
                    connectedCount[x] += path[x][y];
                }
            }

            possibility[0][prison] = 1.0;

            int questionCount = scanner.nextInt();

            for (int question = 0; question < questionCount; question++) {
                int questionVillage = scanner.nextInt();
                getPossibility(passed, villageSize, questionVillage);
                System.out.print(String.format("%.8f", possibility[passed][questionVillage]) + " ");
            }
            System.out.println();
        }
    }

    private static void getPossibility(int passedDay, int villageSize, int endVillage) {
        for (int startVillage = 0; startVillage < villageSize; startVillage++) {
            if (path[startVillage][endVillage] == 1) {
                if (possibility[passedDay - 1][startVillage] == 0.0) {
                    getPossibility(passedDay - 1, villageSize, startVillage);
                }
                possibility[passedDay][endVillage] += possibility[passedDay - 1][startVillage] / connectedCount[startVillage];
            }
        }
    }
//
//    private static void printPossibilities() {
//        System.out.print("    ");
//        for(int i = 0; i < villageCount; i++) {
//            System.out.print(" " + i + "  ");
//        }
//        System.out.println();
//
//        for (int passedDay = 1; passedDay <= passedDays; passedDay++) {
//            System.out.print(passedDay + " | ");
//            for (int endVillage = 0; endVillage < villageCount; endVillage++) {
//                System.out.print(possibility[passedDay][endVillage] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    private static void printConnectedVillagesCount() {
//        for(int x=0; x < villageCount;x++) {
//            System.out.print(x+":"+connectedVillagesCount[x]+" ");
//        }
//        System.out.println();
//    }
}
