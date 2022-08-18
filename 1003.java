// 2022-08-18
// 피보나치 함수

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(in.readLine());
			
			int zero = 1;
			int one = 0;
			int zeroOne = 1;
			
			for(int j=0; j<N; j++) {
				zero = one;
				one = zeroOne;
				zeroOne = zero + one;
			}
			
			System.out.println(zero + " " + one);
		}
	}
}
