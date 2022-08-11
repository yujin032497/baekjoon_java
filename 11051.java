// 2022-08-11
// 이항 계수 2

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		int N = Integer.parseInt(split[0]);
		int K = Integer.parseInt(split[1]);
		
		int[][] dp = new int [N+1][N+1]; // dp배열
		
    /*초기값 설정*/
		for(int i=0; i<=N; i++) {
			dp[i][1] = i;
			dp[i][0] = 1;
			dp[i][i] = 1;
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i-1][j-1])%10007; // 이항계수를 10007로 나눈 값을 넣는다.
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
