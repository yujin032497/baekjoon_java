// 2022-11-06
// 벽 부수고 이동하기 2

import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M,K;
	static int[][] map;
	static int[] dx = {-1,0,1,0}; // 상우하좌
	static int[] dy = {0,1,0,-1};
	static int ans;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		ans = Integer.MAX_VALUE;
		Simulate();
		if(ans==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	private static void Simulate() {
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean [][][] visited = new boolean[N][M][K+1]; // K번 부술 때
		
		q.offer(new int[] {0,0,0,1});
		
		for(int i=0; i<=K; i++) {
			visited[0][0][i] = true;
		}
		
		while(!q.isEmpty()) {
			
			int[] p = q.poll();
			
			int curX = p[0];
			int curY = p[1];
			int crush = p[2];
			
			if(curX == N-1 && curY == M-1) {
				ans = Math.min(ans, p[3]);
				continue;
			}
 			
			for(int i=0; i<4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(isValid(nx,ny)) {
					if(map[nx][ny]==1) { // 벽일 경우
						if(crush<K && !visited[nx][ny][crush+1]) { // 벽을 아직 부술 수 있는 횟수라면 혹은 이미 부셔서 
							visited[nx][ny][crush+1] = true;
							q.offer(new int[] {nx,ny,crush+1,p[3]+1});
						}
					} else { // 벽이 아닌 경우
						if(!visited[nx][ny][crush]) { // 벽 부순 횟수에 대한 방문체크
							visited[nx][ny][crush] = true;
							q.offer(new int[] {nx,ny,crush,p[3]+1});
						}
					}
				}
			}
		}
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<N && ny<M) return true;
		return false;
	}

}

