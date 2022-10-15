// 2022-10-15
// 내리막 길

import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	static int[][] map;
	static int[][] dp;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0}; //상우하좌
	static int[] dy = {0,1,0,-1};
	static long ans;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		dp = new int [N][M];
		visited = new boolean [N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		
		dp[N-1][M-1] = 1;
		DFS(0,0);
		
		ans = dp[0][0];
		System.out.println(ans);
	}
	private static void DFS(int x, int y) {
		
		if(x==N-1 && y==M-1) {
			return;
		}
		
		if(visited[x][y]) {
			return;
		}
		
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isValid(nx,ny) && map[x][y] > map[nx][ny]) {
				if(dp[nx][ny] != 0) {
					dp[x][y] += dp[nx][ny];
					continue;
				} else {
					DFS(nx,ny);
					dp[x][y] += dp[nx][ny];
				}
			}
		}

	}
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<N && ny<M) return true;
		return false;
	}
}
