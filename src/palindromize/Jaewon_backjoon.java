package palindromize;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Jaewon_backjoon {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(bf.readLine());
		String input = bf.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
				
		int[] A = new int[N];
		for(int i = 0; i< N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N][N];
		
		
		//solution
		for(int i = 0; i< N; i++) {
			dp[i][i] = 1;
		}
		//**
		for(int i = 0; i< N-1; i++) {
			if(A[i] == A[i+1]) {
				dp[i][i+1] = 1;
			}
		}
		
		for(int j = 2; j < N; j++) {
			for(int i = 0; i < j-1; i++) {
				if(A[i] == A[j] && dp[i+1][j-1] == 1) {
					dp[i][j] = 1;
				}
			}
		}
		
		int T = Integer.parseInt(bf.readLine());
		int S, E;
		for(int t = 0; t< T; t++) {
			String s = bf.readLine();
			StringTokenizer st1 = new StringTokenizer(s, " ");
			S = Integer.parseInt(st1.nextToken());
			E = Integer.parseInt(st1.nextToken());
			bw.write(dp[S-1][E-1]+"\n");
		}	
		bw.flush();
		bw.close();
		
	}
}
