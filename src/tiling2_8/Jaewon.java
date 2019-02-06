package tiling2_8;

import java.util.Scanner;

public class Jaewon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 0; t< T; t++) {
			int N = sc.nextInt();
			int[] dp = new int[N+1];
			
			if(N == 1) {
				System.out.println(1);
			} else if(N == 2) {
				System.out.println(2);
			} else {
				dp[1] = 1;
				dp[2] = 2;
				
				for(int i = 3; i<= N; i++) {
					dp[i] = (dp[i-1] + dp[i-2])%1000000007;
				}
				System.out.println(dp[N]);
			}
		}
	}
	
}
