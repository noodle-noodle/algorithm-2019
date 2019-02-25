package numb3rs_8;

import java.util.Scanner;

public class Sungyun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine().trim());

		for (int i = 0; i < testCase; i++) {
			int townNum = sc.nextInt();
			int day = sc.nextInt();
			int jail = Integer.parseInt(sc.nextLine().trim());

			int[] adjustCnt = new int[townNum];

			int[][] row = new int[townNum][townNum];
			for (int j = 0; j < townNum; j++) {
				for (int k = 0; k < townNum - 1; k++) {
					row[j][k] = sc.nextInt();
					adjustCnt[j] += row[j][k];
				}
				row[j][townNum - 1] = Integer.parseInt(sc.nextLine().trim());
				adjustCnt[j] += row[j][townNum - 1];
			}

			//  각점에서 다른 점까지 갈 수 있는 확률
			double[][] percent = new double[townNum][townNum];
			for (int j = 0; j < townNum; j++) {
				for (int k = 0; k < townNum; k++) {
					percent[j][k] = (double)row[j][k] / adjustCnt[j];
				}
			}

			double[] yesterday = percent[jail];
			double[] result = new double[townNum];
			for (int j = 0; j < day - 1; j++) {
				result = new double[townNum];
				for (int x = 0; x < townNum; x++) {
					for (int y = 0; y < townNum; y++) {
						if (yesterday[y] != 0) {
							result[x] += yesterday[y] * percent[y][x];
						}
					}
				}
				yesterday = result;
			}

			int resultNum = Integer.parseInt(sc.nextLine().trim());
			for (int j = 0; j < resultNum; j++) {
				System.out.println(result[sc.nextInt()]);
			}
		}
	}
}
