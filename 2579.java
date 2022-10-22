// 2022-10-22
// 계단 오르기

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] floor = new int [N+1];
		
		for(int i=1; i<=N; i++) {
			floor[i] = Integer.parseInt(in.readLine());
		}
		
		long[] dp = new long [N+1];
		dp[1] = floor[1];
		if(N>=2) dp[2] = Math.max(dp[1]+floor[2], dp[0]+floor[2]); // 한번에 두칸 갔는지 1층가고 한칸갔는지 검사
		
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-3]+floor[i-1], dp[i-2])+floor[i];
		}
		
		System.out.println(dp[N]);
	}
}
