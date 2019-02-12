package jumpgame_8;

import java.util.Scanner;

public class Jaewon {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {

			//initialize
			int N = sc.nextInt();
			int[][] A = new int [N][N];
			boolean[][] dp = new boolean[N][N];
			for(int i = 0; i< N; i++) {
				for(int j = 0; j< N; j++) {
					A[i][j] = sc.nextInt();
				}
			}
			
			//solution
			dp[0][0] = true;
			for(int i = 0; i< N; i++) {
				for(int j = 0; j< N; j++) {
					if(dp[i][j] == true && i + A[i][j] < N) {
						dp[i + A[i][j]][j]  = true;
					}
					if(dp[i][j] == true && j + A[i][j] < N) {
						dp[i][j + A[i][j]] = true;
					}
				}
			}
			
			//answer
			if(dp[N-1][N-1] == true) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
}
