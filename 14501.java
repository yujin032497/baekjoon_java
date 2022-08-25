// 2022-08-26
// 퇴사

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] dp;
	static int[] T, P;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		T = new int [N+1];
		P = new int [N+1];
		dp = new int [N+2];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
			
		}
		
		for(int i=N; i>0; i--) {
			if(i+T[i] > N+1) {
				dp[i] = dp[i+1];
			} else {
				dp[i] = Math.max(dp[i+1],P[i]+dp[i+T[i]]);
			}
		}
		
		System.out.println(dp[1]);
	}

}
