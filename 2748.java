// 2022-10-20
// 피보나치 수 2

import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		long[] dp = new long [91];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<91; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[N]);
	}
}
