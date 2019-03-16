package Bj_6118;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Jaewon {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[][] A = new boolean[N+1][N+1];
		int[] B = new int[N+1];
		int a, b;
		
		//initialize
		for(int i = 0; i < M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			A[a][b] = true;
			A[b][a] = true;
		}
		for(int i = 1; i< N+1; i++) {
			B[i] = -1;
		}
		
		//solution
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		B[1] = 0;
		int tmp;
		while(q.isEmpty() == false) {
			tmp = q.poll();
			for(int j = 1; j< N+1; j++) {
				if(B[j] == -1 && A[tmp][j] == true) {
					B[j] = B[tmp] + 1;
					q.add(j);
				}
			}
		}
		
		//answer
		int ans = 0, dist = 0, cnt = 0;
		for(int i = 1; i< N+1; i++) {
			if(B[i] > dist) {
				dist = B[i];
				ans = i;
				cnt = 1;
			} else if(B[i] == dist) {
				cnt++;
			}
		}
		System.out.println(ans + " " + dist + " " + cnt);
	}
	
}
