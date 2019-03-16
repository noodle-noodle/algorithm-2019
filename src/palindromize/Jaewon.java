package palindromize;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Jaewon {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(bf.readLine());
		
		for(int t = 0; t< T; t++) {

			//initialize
			String str = bf.readLine();
			int length = str.length();
			
			//solution
			int result = 0;
			for(int l = 0; l< length; l++) {
				int i = l;
				int j = length - 1;
				while(i < j && str.charAt(i) == str.charAt(j)) {
					i++; j--;
				}
				if(i >= j) {
					result = length + l;
					break;
				}
			}
			
			//answer
			bw.write(result + "\n");
		}
		bw.flush();
		bw.close();
	}
}
