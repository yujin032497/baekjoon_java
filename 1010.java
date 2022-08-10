// 2022-08-10
// 다리놓기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		int[][] dp = new int [31][31]; // M의 범위가 30개까지므로
		
		for(int i=0; i<31; i++) {
			dp[i][1] = 1; // i개중 1개를 선택할 때
			dp[i][0] = 0; // i개중 하나도 선택안할 때
			dp[i][i] = i; // i개중 i개 선택할 때
		}
		
    //dp 세팅
		for(int i=1; i<31; i++) {
			for(int j=1; j<31; j++) {
				dp[i][j] = dp[i-1][j] + dp[i-1][j-1]; // dp공식
			}
		}
		
    // 테스트케이스 결과 출력
		int T = Integer.parseInt(in.readLine());
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			System.out.println(dp[M][N+1]);
		}
	}

}
