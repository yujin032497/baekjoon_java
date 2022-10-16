// 2022-10-16
// 평범한 배낭

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게
		
		int[][] item = new int [N+1][2];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			item[i][0] = Integer.parseInt(st.nextToken()); // 무게
			item[i][1] = Integer.parseInt(st.nextToken()); // 가치
		}
		
		int dp[][] = new int [N+1][K+1];
		
		for(int k=1; k<=K; k++) {
			for(int i=1; i<=N; i++) {
				dp[i][k] = dp[i-1][k];
				if(k - item[i][0] >= 0) {
					dp[i][k] = Math.max(dp[i-1][k], item[i][1] + dp[i-1][k-item[i][0]]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
