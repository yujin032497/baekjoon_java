// 2022-10-21
// 이친수

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		long [][] dp = new long [N+1][2];
		
		dp[1][0] = 0; // 0으로 시작하여 만들 수 있는 수의 개수
		dp[1][1] = 1; // 1로 시작하여 만들 수 있는 수의 개수

		
		for(int i=2; i<=N; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		
		System.out.println(dp[N][0]+dp[N][1]);
		
	}
}
