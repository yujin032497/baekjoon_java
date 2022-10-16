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
		
		int [] weight, value;
		int [][] dp;
		
		weight = new int [N+1]; // 물건의 무게
		value = new int [N+1]; // 물건의 가치
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			weight[i] = w;
			value[i] = v;
		}
		
		dp = new int [N+1][K+1]; // 메모이제이션
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				dp[i][j] = dp[i-1][j]; // 이전 물건의 가치를 초기설정
				
				if(j-weight[i]>=0) { // (비교하려는 무게 - 현재무게)가 0보다 크거나 같다 = 준서가 버틸 수 있는 무게
					// 이전 물건에 대한 무게와 이전 물건에 대한 무게 + 현재 넣을려고 하는 물건과 비교
					// dp[i-1][j-weight[i]] : 비교하려는 무게 - 현재 넣을려고 하는 무게 = 이전 물건에 대한 무게 dp 위치
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
				}
			}
		}
		
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=K; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(dp[N][K]);
	
	}
}
