// 2022-10-19
// 보물섬

import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	static char[][] map;
	static int[][] ans;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int max;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		ans = new int [N][M];
		max = Integer.MIN_VALUE;
		
		// 지도 그리기
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				ans[i][j] = Integer.MIN_VALUE;
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'L') { // 육지라면
					visited = new boolean[N][M];
					BFS(i,j); // 너비우선 탐색 시작
				}
			}
		}
		
		System.out.println(max);
	
	}
	private static void BFS(int x, int y) {
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int [][] tempMap = new int [N][M];
		
		visited[x][y] = true;
		q.offer(new int[] {x, y, 0});
		
		while(!q.isEmpty()) {
			
			int [] p = q.poll();
			
			int curX = p[0];
			int curY = p[1];
			int time = p[2];
			
			for(int i=0; i<4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(isValid(nx,ny) && !visited[nx][ny] && map[nx][ny] == 'L') {
					visited[nx][ny] = true;
					if(tempMap[nx][ny]!=0) {
						tempMap[nx][ny] = Math.min(tempMap[nx][ny], time+1);
					} else tempMap[nx][ny] = time+1;
					q.offer(new int[] {nx, ny, time+1});
				}
			}
		}
		
		calcMinTime(tempMap);
		
	}
	private static void calcMinTime(int[][] tempMap) {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(ans[i][j] < tempMap[i][j]) {
					ans[i][j] = tempMap[i][j];
					if(max<ans[i][j]) max = ans[i][j];
				}
			}
		}
		
	}
	
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<N && ny<M) return true;
		return false;
	}
}
