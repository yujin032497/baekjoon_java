// 2022-08-26
// 1로 만들기

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int X;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		X = Integer.parseInt(in.readLine());
		dp = new int [X+1];
		
		dp[1] = 0;
		for(int i=2; i<=X; i++) {
			dp[i] = dp[i-1]+1;
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
			if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1);
		}
		System.out.println(dp[X]);
	}

}
