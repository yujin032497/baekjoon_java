// 2022-11-09
// 미세먼지 안녕!

import java.io.*;
import java.util.*;
public class Main {
	
	static int R,C,T;
	static int[][] map;
	static int cleaner = -1;
	static int[] dx = {-1,0,1,0}; // 상우하좌
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int [R][C];

		int idx = 0;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(cleaner==-1 && map[i][j]==-1) { // 공기청정기이면
					cleaner = i;
				}
			}
		}
		
		Simulate();
		
		// 먼지의 양 계산
		int ans = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				// 공기청정기 부분은 빼고 계산
				if(map[i][j]!=-1) ans+=map[i][j];
			}
		}
		System.out.println(ans);
	}
	private static void Simulate() {
		
		for(int t=0; t<T; t++) {
			ArrayDeque<int[]> q = new ArrayDeque<>();
			
			// 1. 먼지를 확인한다.
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j]!=0 && map[i][j]!=-1) {
						q.offer(new int[] {i,j,map[i][j]}); // 먼지까지 같이 넣어줘야한다. (확산되면서 맵에 먼지양이 변함)
					}
				}
			}
			
			// 2. 먼지를 확산시킨다.
			while(!q.isEmpty()) {
				
				int[] p = q.poll();
				
				int curX = p[0];
				int curY = p[1];
				int curDust = p[2];
				
				if(curDust<5) continue; // 5보다 작으면 확산되는 양은 0이므로 넘긴다.
				
				// 인접한 칸이 있는지 확인한다.
				int n = curDust/5; // 확산되는 양
				
				int cnt = 0; // 확산된 방향 개수
				for(int i=0; i<4; i++) {
					
					int nx = curX + dx[i];
					int ny = curY + dy[i];
					
					if(isValid(nx,ny) && map[nx][ny]!=-1) { // 배열 범위를 벗어나지 않았거나 공기청정기가 아니면
						map[nx][ny] += n; // 인접한 칸에 먼지를 확산 시키고
						cnt++; // 확산된 칸 +1 카운팅
					}
				}
				
				map[curX][curY] = map[curX][curY] - (n*cnt); // 확산시키고 남은 먼지
			}
			
			// 3. 공기청정기가 작동한다.
			Operate();
		}
		
		
	}
	private static void Operate() {
		
		// 공기청정기는 항상 1번열에 설치
		int top = cleaner;
		int bottom = cleaner+1;
		
		// 위쪽 공기청정기는 반 시계방향
		
		// 아래로 당기기
		for(int i=top-1; i>0; i--) {
			map[i][0] = map[i-1][0];
		}
		// 왼쪽으로 당기기
		for(int i=0; i<C-1; i++) {
			map[0][i] = map[0][i+1];
		}
		// 위로으로 당기기
		for(int i=0; i<top; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		// 오른쪽으로 당기기
		for(int i=C-1; i>1; i--) {
			map[top][i] = map[top][i-1];
		}
		
		map[top][1] = 0;
		
		// 아래쪽 공기청정기는 시계방향
		
		// 위로 당기기
		for(int i=bottom+1; i<R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		
		// 왼쪽으로 당기기
		for(int i=0; i<C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		
		// 아래로 당기기
		for(int i=R-1; i>bottom; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		
		// 오른쪽으로 당기기
		for(int i=C-1; i>1; i--) {
			map[bottom][i] = map[bottom][i-1];
		}
		
		map[bottom][1] = 0;
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<R && ny<C) return true;
		return false;
	}

}
