// 2022-10-22
// 가장 큰 증가부분 수열

import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		long [] num = new long [N+1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=1; i<=N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		long [] dp = new long [N+1];
		
		for(int i=1; i<=N; i++) {
			dp[i] = num[i];
		}

		long max = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<i; j++) {
				if(num[j]<num[i]) {
					dp[i] = Math.max(dp[j]+num[i], dp[i]);
				}
			}
			
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
