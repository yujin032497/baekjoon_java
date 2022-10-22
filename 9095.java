// 2022-10-22
// 1,2,3 더하기

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = Integer.parseInt(in.readLine());
			
			int [][] dp = new int [3][N+1];
			
			dp[0][1] = 1;
			if(N>=2) {
				dp[0][2] = 1;
				dp[1][2] = 1;
			}
			if(N>=3) {
				dp[0][3] = dp[0][0] + dp[0][1] + dp[0][2];
				dp[1][3] = dp[1][0] + dp[1][1] + dp[1][2];
				dp[2][3] = 1;
 			}
			
			for(int i=4; i<=N; i++) {
				dp[0][i] = dp[0][i-3] + dp[0][i-2] + dp[0][i-1];
				dp[1][i] = dp[1][i-3] + dp[1][i-2] + dp[1][i-1];
				dp[2][i] = dp[2][i-3] + dp[2][i-2] + dp[2][i-1];
			}
			
			sb.append(dp[0][N]+dp[1][N]+dp[2][N]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
