// 2022-10-22
// 이동하기

import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int [N+1][M+1];
	
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int [][] dp = new int [N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				dp[i][j] = Math.max(map[i][j]+dp[i-1][j], map[i][j]+dp[i][j-1]);
			}
		}
		
		System.out.println(dp[N][M]);
	}
}
