package numb3rs_8;

import java.util.Scanner;

public class Jaewon {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int t = 0; t< T; t++) {
			//initialize
			int N = sc.nextInt();	//마을의 수
			int d = sc.nextInt();	//지난 일수
			int p = sc.nextInt();	//교도소가 있는 마을의 번호
			int[][] A = new int[N][N];
			int[] sum = new int[N];	//i 마을에 연결된 마을의 수
			double[][] dp = new double[N][d+1];
			
			for(int i = 0; i< N; i++) {
				for(int j = 0; j< N; j++) {
					A[i][j] = sc.nextInt();	
					sum[i] += A[i][j];
				}
			}
					
			//solution
			for(int i = 0; i< N; i++) {
				if(A[i][p] == 1) {
					dp[i][1] = (double)1/sum[p];
				}
			}
			
			//**
			if(d != 1) {
				for(int j = 2; j<= d; j++) {
					for(int i = 0; i< N; i++) {
						for(int k = 0; k< N; k++) {
							if(A[i][k] == 1) {	//연결된 경우
								dp[i][j] += ((double)1/sum[k]) * dp[k][j-1];	//**형변환
							}
						}
					}
				}
			}

			//answer
			int C = sc.nextInt();
			int q;
			for(int c = 0; c < C; c++) {
				q = sc.nextInt();
				System.out.println(dp[q][d]);
			}
		}	
	}
}
