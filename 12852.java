// 2022-08-26
// 1로 만들기 2

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int X;
	static int[] dp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(in.readLine());
		
		dp = new int [X+1];
		dp[1] = 0;
	
		for(int i=2; i<=X; i++) {
			dp[i] = dp[i-1]+1;
			if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1);
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
		}
		sb.append(dp[X]).append("\n").append(X).append(" ");
		dfs(X);
		
		System.out.println(sb.deleteCharAt(sb.length()-1));
	}
	private static void dfs(int n) {
		if(n==1) {
			return;
		}
		int tmp = n-1;
		if(n%2==0) {
			if(dp[tmp]>dp[n/2]) tmp = n/2;
		}
		if(n%3==0) {
			if(dp[tmp]>dp[n/3]) tmp = n/3;
		}
		sb.append(tmp).append(" ");
		dfs(tmp);
	}
}
