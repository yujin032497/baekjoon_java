// 2022-11-04
// 공주님을 구해라!

import java.io.*;
import java.util.*;
public class Main {
	
	static int N,M,T;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int time;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int [N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		time = Integer.MAX_VALUE;
		Simulate();
		if(time==Integer.MAX_VALUE) System.out.println("Fail");
		else System.out.println(time);
	}
	private static void Simulate() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N+1][M+1][2];
		
		visited[1][1][0] = true;
		q.offer(new int[] {1,1,0,0});
		
		while(!q.isEmpty()) {
			
			int[] p = q.poll();
			
			int curX = p[0];
			int curY = p[1];
		
			if(p[3]>T) continue;
			
			if(curX == N && curY == M) {
				
				time = Math.min(time, p[3]);
				continue;
			}
			
			for(int i=0; i<4; i++) {
				
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				int isGram = p[2]; // 4방탐색하면서 그람이 있는지 없는지 여부를 조사한다.
			
				if(!isValid(nx,ny)) continue;
				if(isGram==0) { // 그람이 없을 경우
					if(visited[nx][ny][0] || map[nx][ny] == 1) continue; // 방문했고 마법벽이라면 지나갈 수 없음
					if(map[nx][ny]==2) isGram = 1; // 그람을 주었다.
				} else { // 그람이 있으면
					
					if(visited[nx][ny][1]) continue;
				}
				
				visited[nx][ny][isGram] = true;
				q.offer(new int[] {nx, ny, isGram, p[3]+1});
				
			}
			
		}
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>=1 && ny>=1 && nx<=N && ny<=M) return true;
		return false;
	}

}
