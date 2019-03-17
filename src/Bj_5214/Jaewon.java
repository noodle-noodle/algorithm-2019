package Bj_5214;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Jaewon {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int M = sc.nextInt();
		LinkedList[] list = new LinkedList[M];
		for(int m = 0; m < M; m++) {
			list[m] = new LinkedList<Integer>();
		}
		
		for(int m = 0; m < M; m++) {
			for(int k = 0; k< K; k++) {
				list[m].add(sc.nextInt());
			}
		}
		
		//initialize
		int[] dp = new int[N+1];
		for(int i = 1; i< N+1; i++) {
			dp[i] = -1;
		}
		
		//solution
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		dp[1] = 1;
		int t;
		int idx;
		while(q.isEmpty() == false) {
			t = q.poll();
			for(int m = 0; m < M; m++) {
				if(list[m].contains(t) ) {
					for(int k = 0; k< K; k++) {
						idx = (int) list[m].get(k);
						if(idx == N) {
							System.out.println(dp[t] + 1);
							return;
						}
						if(dp[idx] == -1) {
							dp[idx] = dp[t] + 1;
							q.add(idx);
						}
					}
				}
			}
		}
		
		//test
		for(int i = 1; i< N + 1; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		
		//answer
		System.out.println(dp[N]);
		
		
	}
	
}
