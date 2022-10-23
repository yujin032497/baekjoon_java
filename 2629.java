// 2022-10-23
// 양팔저울

import java.io.*;
import java.util.*;
public class Main {
	
	static int N,M;
	static int[] chu, bean;
	static boolean[][] dp;
    public static void main(String[] args) throws Exception {
      
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(in.readLine());
    	
    	chu = new int [N];
    	
    	StringTokenizer st = new StringTokenizer(in.readLine());
    	
    	for(int i=0; i<N; i++) {
    		chu[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	M = Integer.parseInt(in.readLine());
    	
    	bean = new int [M];
    	
    	st = new StringTokenizer(in.readLine());
    	
    	for(int i=0; i<M; i++) {
    		bean[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	dp = new boolean [N+1][55001];
    	
    	dfs(0,0);
    	
    	for(int i=0; i<M; i++) {
    		if(dp[N][bean[i]]) {
    			System.out.print("Y ");
    		}else {
    			System.out.print("N ");
    		}
    	}
    }
	private static void dfs(int cnt, int weight) {
		
		if(dp[cnt][weight]) return;
		
		dp[cnt][weight] = true;
		
		if(cnt==N) return;
		
		dfs(cnt+1, weight + chu[cnt]); // 추의 무게를 더한다.
		dfs(cnt+1, weight); // 추의 무게를 빼고 계산
		dfs(cnt+1, Math.abs(weight-chu[cnt])); // 옆 저울에 추를 올린다.
		
	}
}
