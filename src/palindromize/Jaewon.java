package palindromize;

import java.util.Scanner;

public class Jaewon {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		for(int t = 0; t< T; t++) {

			//initialize
			String str = sc.nextLine();
			int length = str.length();
			
			//solution
			int result = 0;
			for(int l = 0; l< length; l++) {
				int i = l;
				int j = length - 1;
				while(i < j && str.charAt(i) == str.charAt(j)) {
					i++; j--;
				}
				if(i == j) {
					result = length + l;
					break;
				}
			}
			
			//answer
			System.out.println(result);
		}
	}
}
