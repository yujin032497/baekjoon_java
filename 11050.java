// 2022-08-11
// 이항 계수 1

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		int N = Integer.parseInt(split[0]);
		int K = Integer.parseInt(split[1]);
		
		int[][] dp = new int [N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			dp[i][1] = i; // i개중 하나씩 뽑으면 i번
			dp[i][0] = 1; // i개중 하나도 안뽑으면 0번
			dp[i][i] = 1; // i개중 i개 모두 뽑으면 1번
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=1; j<i; j++) {
				dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
			}
		}
		System.out.println(dp[N][K]);
	}

}
