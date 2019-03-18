package wine_backjoon;

import java.util.Scanner;

public class Jaewon {
	static int N;
	static int[] A;
	
	public static int calc(int i, int cont, int sum) {
		
		if(i == N) {
			return sum;
		}
		
		if(cont == 2) {
			return calc(i + 1, 0, sum);
		} else {
			return Math.max(calc(i + 1, cont + 1, sum + A[i]), calc(i + 1, 0, sum));
		}		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//initialize
		N = sc.nextInt();
		A = new int[N];
		for(int i = 0; i< N; i++) {
			A[i] = sc.nextInt();
		}
		
		//solution
		System.out.println(calc(0, 0, 0));
	
	}
}
