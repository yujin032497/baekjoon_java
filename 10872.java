// 2022-09-13
// 팩토리얼

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main (String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int ans = factorial(N);
		System.out.println(ans);
	

	}
	private static int factorial(int n) {
		if(n<2) return 1;
		else return n * factorial(n-1);
		
	}

}
