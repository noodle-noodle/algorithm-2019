package pi_8;

import java.util.Scanner;

public class Jaewon {
	
	static int[] A;
	static int[] dp;
	static boolean[] flag;	//defalut: false
	public static int calc(int startIndex, int endIndex) {
		
		if(calc1(startIndex, endIndex)) {
			return 1;
		} else if(calc2(startIndex, endIndex)) {
			return 2;
		} else if(calc3(startIndex, endIndex)) {
			return 2;
		} else if(calc4(startIndex, endIndex)) {
			return 4;
		} else if(calc5(startIndex, endIndex)) {
			return 5;
		} else {
			return 10;
		}
	}

	public static boolean calc1(int startIndex, int endIndex) {
		for(int k = startIndex; k< endIndex; k++) {
			if(A[k] != A[k+1]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean calc2(int startIndex, int endIndex) {
		for(int k = startIndex; k< endIndex; k++) {
			if(A[k] + 1 != A[k+1]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean calc3(int startIndex, int endIndex) {
		for(int k = startIndex; k< endIndex; k++) {
			if(A[k] - 1 != A[k+1]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean calc4(int startIndex, int endIndex) {
		for(int k = startIndex; k< endIndex-1; k++) {
			if(A[k] != A[k+2]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean calc5(int startIndex, int endIndex) {
		for(int k = startIndex; k< endIndex-1; k++) {
			if(A[k + 1] - A[k] != A[k+2] - A[k+1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();

		for(int t = 0; t< T; t++) {
			//initialize
			String input = sc.nextLine();
			int N = input.length();
			A = new int[N];
			dp = new int[N];
			flag = new boolean[N];
			for(int i = 0; i< N; i++) {
				A[i] = Character.getNumericValue(input.charAt(i));
				dp[i] = 987654321;	//**inf
			}
			
			//solution
			dp[0] = 0;
			dp[1] = 0;
			for(int j = 2; j< 5; j++) {
				if(j < N) {
					dp[j] = Math.min(dp[j], calc(0, j));
					flag[j] = true;
				}
			}
			int tmp;
			for(int i = 3; i< N; i++) {
				for(int j = 2; j< 5; j++) {
					if(i + j < N && flag[i + j] == true) {
						dp[i + j] = Math.min(dp[i + j], dp[i-1] + calc(i, i + j));
						flag[i + j] = true;
					} else if(i + j < N) {
						dp[i + j] = dp[i-1] + calc(i, i + j);
						flag[i + j] = true;
					}
				}
			}

			//answer
			System.out.println(dp[N-1]);
		}
		
	}
	
}