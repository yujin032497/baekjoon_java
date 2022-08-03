// 2022-08-03
// 구간 합 구하기 5

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
    //dp배열의 구간을 (1,1)부터 시작을 위해 N+1만큼 배열 생성
		int[][] dp = new int [N+1][N+1];
		
    //가로누적합
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=N; j++) {
				dp[i][j] = dp[i][j-1] + Integer.parseInt(st.nextToken()); 
			}
		}
		
    //세로누적합
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j];
			}
		}
		
    //좌표 받기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
      /*2차원배열 dp구간 합*/
			int ans = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
      
			System.out.println(ans);
		}
	}
}
