// 2022-09-29
// RGB거리

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] dp = new int [N+1][3]; //N * 색깔개수(R,G,B)
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
		
      // 비용
			int r = Integer.parseInt(st.nextToken()); //빨강색
			int g = Integer.parseInt(st.nextToken()); // 초록색
			int b = Integer.parseInt(st.nextToken()); // 파란색
     
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r; // 전에 칠한 색의 초록과 파랑의 비용을 비교한 후 빨강 비용 더하기
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + g; // 전에 칠한 색의 빨강과 파랑의 비용을 비교한 후 초록 비용 더하기
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b; // 전에 칠한 색의 빨강과 초록의 비용을 비교한 후 파랑 비용 더하기
		
		}
		
    // 맨 마지막줄의 빨강[0], 초록[1], 파랑[2]의 비용이 최종 비용으로
    // 셋 중 제일 작은것이 최소 비용
		int ans = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
		System.out.println(ans);
	}

}
