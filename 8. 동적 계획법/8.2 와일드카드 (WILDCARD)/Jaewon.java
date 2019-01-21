
import java.util.Scanner;

public class Jaewon {
	
	static String W, S;
	static int[][] dp;
	
	public static int calc(int w, int s) {

		if(W.length() <= w+1 && W.charAt(W.lastIndexOf(W)) == '*') {
			return 1;
		}
		if(W.length() < w || S.length() < s) {
			return -1;
		}

		if(dp[w][s] != 0) {
			return dp[w][s];
		}
		while(s < S.length() && w < W.length() && (W.charAt(w) == '?' || W.charAt(w) == S.charAt(s))) {
			w++;
			s++;
		}
		if(W.length() <= w) {	//length는 index(0~ㅣ-1)이므로
			if(S.length() == s) {
				return 1;
			} else {
				return -1;
			}
		}
		if(S.length() <= s) {
			int tmp = w;
			while(tmp < W.length() && W.charAt(tmp) == '*') {
				tmp++;
			}
			if(tmp == W.length()) {
				return 1;
			}
		}
		
		if(W.charAt(w) == '*') {
			for(int i = 0; i + s< S.length(); i++) {
				if(calc(w+1, s+i) == 1) {
					dp[w][s] = 1;
					return dp[w][s];
				}
			}
		}
		dp[w][s] = -1;
		return dp[w][s];
 		
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for(int t= 0; t < T; t++) {
			W = sc.nextLine();
			int N = Integer.parseInt(sc.nextLine());
			for(int n = 0; n< N; n++) {
				S = sc.nextLine();
				dp = new int[W.length()][S.length()];
				
				if(calc(0, 0) == 1) {
					System.out.println(S);
				}
			}
		}
	}
	
}
