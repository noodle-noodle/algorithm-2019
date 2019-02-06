package tripathcnt_8;

import java.util.Scanner;

public class Jaewon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t< T; t++) {
			//initialize
			int N = sc.nextInt();
			int[][] A = new int[N][N];
			int[][] dp = new int[N][N];	//합의 최댓값
			int[][] ans = new int[N][N];	//최댓값 경로의 수
			for(int i = 0; i< N; i++) {
				for(int j = 0; j<= i; j++) {
					A[i][j] = sc.nextInt();
				}
			}
			
			//solution
			dp[0][0] = A[0][0];
			ans[0][0] = 1;
			for(int i = 0; i< N-1; i++) {
				for(int j = 0; j<= i; j++) {
					
					if(dp[i+1][j] == dp[i][j] + A[i+1][j]) {
						ans[i+1][j] = ans[i+1][j] + ans[i][j];
					} else if(dp[i+1][j] < dp[i][j] + A[i+1][j]){
						ans[i+1][j] = ans[i][j];
					}
					ans[i+1][j+1] = ans[i][j];
					
					dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + A[i+1][j]);
					dp[i+1][j+1] = dp[i][j] + A[i+1][j+1];
				}
			}
			
			//answer
			int max = 0;	//dp
			int result = 0;	//ans
			for(int j = 0; j< N; j++) {
				if(max < dp[N-1][j]) {
					max = dp[N-1][j];
					result = ans[N-1][j];
				} else if(max == dp[N-1][j]) {
					result += ans[N-1][j];
				}
			}
			System.out.println(result);
		}		
	}
	
}
