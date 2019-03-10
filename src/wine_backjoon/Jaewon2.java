package wine_backjoon;

import java.util.Scanner;

public class Jaewon2 {
	
	static int N;
	static int[] A;
	static int[] dp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//initialize
		N = sc.nextInt();
		A = new int[N];
		dp = new int[N];
		for(int i = 0; i< N; i++) {
			A[i] = sc.nextInt();
		}
		
		//solution
		if(N == 1) {
			System.out.println(A[0]);
			return;
		} else if(N == 2) {
			System.out.println(A[0] + A[1]);
			return;
		}
		
		dp[0] = A[0];
		dp[1] = A[0] + A[1];
		for(int i = 2; i< N; i++) {
			dp[i] = A[i] + A[i-1];
		}
		dp[2] = Math.max(dp[2],  A[0] + A[2]);
		dp[2] = Math.max(dp[2],  A[0] + A[1]);
		
		for(int i = 3; i< N; i++) {
			int result = Math.max(dp[i-1],  dp[i-2] + A[i]);	//dp[i-2] + A[i]
			result = Math.max(result, A[i] + A[i-1] + dp[i-3]);
			dp[i] = result;
		}
		
		//answer
		System.out.println(dp[N-1]);
		
	}
	
}
