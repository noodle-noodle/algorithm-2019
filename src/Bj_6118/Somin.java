package Bj_6118;

import java.util.Scanner;

public class Somin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int barnCount = scanner.nextInt();
        int pathCount = scanner.nextInt();

        int[][] pathArray = new int[barnCount][barnCount];
        int[] shortestDistance = new int[barnCount];

        for (int i = 0; i < pathCount; i++) {
            int startBarn = scanner.nextInt();
            int endBarn = scanner.nextInt();

            if (startBarn < endBarn) {
                pathArray[startBarn - 1][endBarn - 1] = 1;
            } else {
                pathArray[endBarn - 1][startBarn - 1] = 1;
            }
        }

        setDistance(barnCount, pathArray, shortestDistance, 1, 1);

        int maxDistance = 0;
        int smallestBarn = 0;
        int sameDistanceCount = 1;

        for (int i = 1; i <= barnCount; i++) {
            if (maxDistance < shortestDistance[i - 1]) {
                maxDistance = shortestDistance[i - 1];
                smallestBarn = i;
                sameDistanceCount = 1;
            } else if (maxDistance == shortestDistance[i - 1]) {
                sameDistanceCount++;
            }
        }

        System.out.print(smallestBarn + " " + maxDistance + " " + sameDistanceCount);
    }

    private static void setDistance(int barnCount, int[][] pathArray, int[] shortestDistance, int source, int distance) {
        for (int j = source + 1; j <= barnCount; j++) {
            if (pathArray[source - 1][j - 1] == 1) {
                shortestDistance[j - 1] = distance;
                setDistance(barnCount, pathArray, shortestDistance, j, distance + 1);
            }
        }
    }
}
