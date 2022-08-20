// 2022-08-20
// 조합

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	static BigInteger N = BigInteger.ONE;
	static BigInteger M = BigInteger.ONE;
	static BigInteger totCnt;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		
		for(int i=0; i<m; i++) {
			N = N.multiply(new BigInteger(String.valueOf(n-i)));
			M = M.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		totCnt = N.divide(M);
		System.out.println(totCnt);
	}

}
