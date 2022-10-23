// 2022-10-23
// 욕심쟁이 판다

import java.io.*;
import java.util.*;
public class Main {
	
	static int N;
	static long[][] map;
	static int[][] dp;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int ans = 0;
    public static void main(String[] args) throws Exception {
  
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(in.readLine());
    	
    	map = new long [N][N];
    	dp = new int [N][N];
    	
    	for(int i=0; i<N; i++) {
    		StringTokenizer st = new StringTokenizer(in.readLine());
    		for(int j=0; j<N; j++) {
    			map[i][j] = Long.parseLong(st.nextToken());
    		}
    	}
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			ans = Math.max(ans, DFS(i,j));
    		}
    	}
    	System.out.println(ans);
    }
	private static int DFS(int x, int y) {
		
		if(dp[x][y]!=0) return dp[x][y];

		dp[x][y] = 1;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isValid(nx,ny) && map[x][y] < map[nx][ny]) {
				
				dp[x][y] = Math.max(dp[x][y], DFS(nx,ny)+1);
				DFS(nx,ny);
			}
		}
		return dp[x][y];
		
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<N && ny<N) return true;
		return false;
	}
  
}
