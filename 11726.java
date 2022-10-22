// 2022-10-22
// 2*n 타일링

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		long [] dp = new long [N+1];
		
		dp[1] = 1;
		if(N>=2) dp[2] = 2;
		
		for(int i=3; i<=N; i++) {
			dp[i] = (dp[i-2]+dp[i-1])%10007;
		}
		
		System.out.println(dp[N]);
	}
}
