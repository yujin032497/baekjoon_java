// 2022-10-23
// 동전 1
import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int [N];
		
		for(int i=0; i<N; i++) {
			coins[i] = Integer.parseInt(in.readLine());
		}
		
		int [] dp = new int [K+1];
		
		dp[0] = 1;
		for(int i=0; i<N; i++) {
			for(int j=1; j<=K; j++) {
				if(j>=coins[i]) dp[j] = dp[j] + dp[j - coins[i]]; 
			}
		}
		
		System.out.println(dp[K]);
	}
}
