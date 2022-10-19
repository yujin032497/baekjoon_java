// 2022-10-19
// 불!

import java.io.*;
import java.util.*;

public class Main {

	static int R,C, fX, fY;
	static char[][] map;
	static boolean[][] visited;
	static ArrayDeque<int[]> q = new ArrayDeque<>();
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean isPossible;
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char [R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			map[i] = in.readLine().toCharArray(); 
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]=='F') {
					visited[i][j] = true;
					q.offer(new int[] {i,j,0,1}); // 불이 난 공간부터 먼저 큐에 넣는다.
				}
				if(map[i][j]=='J') {
					fX = i; // 지훈이가 있는 위치는 좌표로 저장한다.
					fY = j;
				}
			}
		}
		
		// 불이난 공간을 다 넣었다면 마지막에 지훈이가 있는 공간좌표를 큐에 넣는다.
		visited[fX][fY] = true;
		q.offer(new int[] {fX, fY,0,2});
		
		isPossible = false;
		ans = Integer.MAX_VALUE;
		BFS();
		
		if(!isPossible) System.out.println("IMPOSSIBLE");
		else System.out.println(ans);
	}
	private static void BFS() {
		
		while(!q.isEmpty()) {
			
			int [] p = q.poll();
			
			int curX = p[0];
			int curY = p[1];
			int time = p[2];
			int type = p[3];
			
			for(int i=0; i<4; i++) {
				
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(type==2) { // 지훈이가 배열 범위 밖이라면 탈출할 수 있는 경우이다.
					if(!isValid(nx,ny)) {
						isPossible = true;
						ans = Math.min(ans, time+1);
						return;
					}
				}
				
				// 이동하려는 좌표가 범위 안이고 한번도 방문을 안했고 벽이 아니라면 => 지나갈 수 있는 공간
				if(isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] != '#') {
					
					if(type==1)	{ // 불이 이동할 차례라면
						map[nx][ny] = 'F'; // 다음 이동할 곳에 불을 표시하고
						visited[nx][ny] = true; // 방문했다고 표시
						q.offer(new int[] {nx, ny, time+1, type}); // 1분증가
					}
					else { // 지훈이가 이동할 차례라면 지도에 
		
						if(map[nx][ny] != 'F') { // 불 표시가 없다면
							map[nx][ny] = 'J'; // 지훈이가 이동할 수 있다.
							visited[nx][ny] = true; // 방문했다고 표시
							q.offer(new int[] {nx, ny, time+1, type}); // 1분증가
							
						}
					}
				}
			}
		}
		
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<R && ny<C) return true;
		return false;
	}
}
