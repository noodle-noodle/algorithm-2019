package palindromize;

import java.util.Scanner;

public class Jaewon2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		for(int t = 0; t< T; t++) {

			//initialize
			String str = sc.nextLine();
			int N = str.length();
			boolean[][] dp = new boolean[N][N];
			
			//solution
			for(int i = N-1; i>= 0; i--) {
				for(int j = i; j < N; j++) {
					if(i == j) {
						dp[i][j] = true;
					} else if(str.charAt(i) == str.charAt(j) && i+1 <N && j-1 >=0 && dp[i+1][j-1] == true) {
						dp[i][j] = true;
					}
				}
			}
			
			//answer
			int res = 0;
			for(int i = 0; i< N ; i++) {
				if(dp[i][N-1] == true) {
					res = N + i;
					break;
				}
			}
			System.out.println(res);
		}
	}
}
