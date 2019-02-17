package poly_8;

import java.util.Scanner;

public class Jaewon {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t< T; t++) {

			//initialize
			int N = sc.nextInt();
			int[][] dp = new int[N+1][N+1];	//첫 줄이 i개 총 j개인 폴리오미노의 수
			
			//solution**
			if(N == 1) {
				System.out.println(1);
				continue;
			} else if(N == 2) {
				System.out.println(2);
				continue;
			}		
			
			dp[1][1] = 1;
			dp[2][1] = 1;
			dp[2][2] = 1;
			for(int i = 3; i< N+1; i++) {
				for(int j = 1; j< i; j++) {
					for(int k = 1; k<= i-j; k++) {
						//dp[i][j] += (dp[i-j][k] * (j+k-1))%10000000;
						dp[i][j] = (dp[i][j] + (dp[i-j][k] * (j+k-1))) % 10000000;
					}
				}
				dp[i][i] = 1;
			}

			//answer
			int ans = 0;
			for(int i = 1; i< N+1; i++) {
				ans += dp[N][i];
			}
			System.out.println(ans%10000000);	//**
		}
	}
}
