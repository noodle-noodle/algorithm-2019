package snail_8;

import java.util.Scanner;

public class Jaewon {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			//initialize
			double p = 0.75;	//흐릴 확률 = 2칸
			double q = 1 - p;	//맑을 확률 = 1칸
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max = Math.max(N, 2*M);
			double[][] dp = new double[max + 1][M+1];	//M일째 N칸을 갈 확률
			dp[1][1] = q;
			dp[2][1] = p;

			//solution
			for(int j = 2; j<= M; j++) {
				for(int i = j; i <= 2*j; i++) {
					if(i -2 >= 0) {
						dp[i][j] = dp[i-1][j-1] * q + dp[i-2][j-1] * p;
					}
				}
			}

			//answer
			double ans = 0;
			for(int k = N; k<= 2*M; k++) {
				ans += dp[k][M];
			}
			System.out.println(ans);		
		}		
	}
	
}
