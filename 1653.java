// 2022-10-23
// 양팔 저울

import java.io.*;
import java.util.*;
public class Main {
	
	static int N,S;
	static int[] chu;
	static boolean[][] dp;
    public static void main(String[] args) throws Exception {
      
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(in.readLine());
    	
    	chu = new int [N];
    	
    	StringTokenizer st = new StringTokenizer(in.readLine());
    	
    	for(int i=0; i<N; i++) {
    		chu[i] = Integer.parseInt(st.nextToken());
    		S+=chu[i];
    	}
    	
    	dp = new boolean [N+1][S+1];
    	
    	dfs(0,0);
    	
    	int ans = 0;
    	for(int i=1; i<=S; i++) {
    		if(!dp[N][i]) ++ans;
    	}
    	
    	System.out.println(ans);
	}
	private static void dfs(int cnt, int weight) {
		
		if(dp[cnt][weight]) return;
		
		dp[cnt][weight] = true;
		
		if(cnt==N) return;
		
		dfs(cnt+1, weight+chu[cnt]);
		dfs(cnt+1, weight);
		dfs(cnt+1, Math.abs(weight-chu[cnt]));
	}
}
