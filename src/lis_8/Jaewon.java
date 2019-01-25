package lis_8;

import java.util.Scanner;

public class Jaewon {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t< T; t++) {
			//initialize
			int N = sc.nextInt();
			int[] A = new int[N];
			int[] dp = new int[N];
			for(int i = 0; i< N; i++) {
				A[i] = sc.nextInt();
				dp[i] = 1;	//**
			}
			
			//solution
			dp[0] = 1;
			for(int i = 0; i< N; i++) {
				for(int j = 0; j< i; j++) {
					if(A[j] < A[i] && dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
					}
				}
			}
			
			//answer
			int ans = 0;
			for(int i = 0; i< N; i++) {
				if(dp[i] > ans) {
					ans = dp[i];
				}
			}
			System.out.println(ans);
		}

	}
	
}
