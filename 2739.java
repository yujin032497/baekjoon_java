// 2022-07-09
// 구구단

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		int N;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<10; i++) {
			System.out.println(N + " * " + i + " = " + N*i);
		}
		
	}

}
