package trianglepath_8;

import java.util.Scanner;

public class Jaewon {
	
	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t< T; t++) {
			int N = sc.nextInt();
			
			int[][] A = new int[N][N];
			int[][] dp = new int[N][N];
			
			for(int i = 0; i< N; i++) {
				for(int j = 0; j<= i; j++) {
					A[i][j] = sc.nextInt();
				}
			}
			
			//solution
			dp[0][0] = A[0][0];
			for(int i = 0; i< N-1; i++) {
				for(int j = 0; j<= i; j++) {
					dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + A[i+1][j]);
					dp[i+1][j+1] = dp[i][j] + A[i+1][j+1];
				}
			}		
			
			//answer
			int ans = 0;
			for(int i = 0; i< N; i++) {
				if(dp[N-1][i] > ans) {
					ans = dp[N-1][i];
				}
			}
			System.out.println(ans);
		}
		
	}
}
