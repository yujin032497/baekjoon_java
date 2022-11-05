// 2022-11-05
// 구슬 탈출

import java.io.*;
import java.util.*;
public class Main {
	
	static class Bead {
		int redX;
		int redY;
		int blueX;
		int blueY;
		int cnt;
		
		public Bead (int redX, int redY, int blueX, int blueY, int cnt) {
			this.redX = redX;
			this.redY = redY;
			this.blueX = blueX;
			this.blueY = blueY;
			this.cnt = cnt;
		}
	}
	static int N,M;
	static char [][] map;
	static int [] dx = {-1,0,1,0}; //상우하좌
	static int [] dy = {0,1,0,-1};
	static Bead bead;
	static int ans;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char [N][M];
		for (int i=0; i<N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		bead = new Bead(0,0,0,0,1); // 초기횟수 1로 설정
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]=='B') {
					bead.blueX = i;
					bead.blueY = j;
				}
				else if(map[i][j]=='R') {
					bead.redX = i;
					bead.redY = j;
				}
			}
		}
		
		ans = 0;
		Simulate();
		System.out.println(ans);
	}
	private static void Simulate() {
	
		ArrayDeque<Bead> q = new ArrayDeque<>();
		boolean [][][][] visited = new boolean [N][M][N][M];
		
		visited[bead.redX][bead.redY][bead.blueX][bead.blueY] = true;
		q.offer(bead);
		
		while(!q.isEmpty()) {
			
			Bead curBead = q.poll();
			
			int curRx = curBead.redX;
			int curRy = curBead.redY;
			int curBx = curBead.blueX;
			int curBy = curBead.blueY;
			int curCnt = curBead.cnt;
			
			if(curCnt>10) {
				continue;
			}
			
			// 1. 구슬 방향을 정한다.
			for(int i=0; i<4; i++) {
	
				int nRx = curRx;
				int nRy = curRy;
				int nBx = curBx;
				int nBy = curBy;
				
				boolean isRedHole = false;
				boolean isBlueHole = false;
				
				//2-1. 정한 방향으로 빨간 구슬을 굴려본다.
				while(map[nRx+dx[i]][nRy+dy[i]] != '#') {
					
					nRx += dx[i];
					nRy += dy[i];
				
					if(map[nRx][nRy]=='O') {
						isRedHole = true;
						break; // 구멍을 만나면 굴리기 종료
						
					}
				}
				
				// 2-2. 정한 방향으로 파란 구슬을 굴려본다.
				while(map[nBx+dx[i]][nBy+dy[i]] != '#') {
					
					nBx += dx[i];
					nBy += dy[i];
				
					if(map[nBx][nBy]=='O') {
						isBlueHole = true;
						break; // 구멍을 만나면 굴리기 종료
					}
				}
				
				if(isBlueHole) continue; // 파란 구슬이 구멍에 통과하면 다른 방향 탐색 해본다.
				if(isRedHole && !isBlueHole) {
					ans = 1;
					return;
				}
				
				// 이동하다가 두 구슬이 위치가 같아질 경우
				if(nRx==nBx && nRy==nBy) {
					if(i==0) { // 위쪽으로 굴렸을 경우
 						if(curRx > curBx) nRx -= dx[i];
 						else nBx -= dx[i];
					} else if (i==1) { // 오른쪽으로 굴렸을 경우
						if(curRy < curBy) nRy -= dy[i];
						else nBy -= dy[i];
					} else if(i==2) { // 아래쪽으로 굴렸을 경우
						if(curRx < curBx) nRx -= dx[i];
						else nBx -= dx[i];
					} else if(i==3) { // 왼쪽으로 굴렸을 경우
						if(curRy > curBy) nRy -= dy[i];
						else nBy -= dy[i];
					}
				}
				
				// 두 구슬이 처음 방문한 곳만 큐에 추가
				if(!visited[nRx][nRy][nBx][nBy]) {
					visited[nRx][nRy][nBx][nBy] = true;
					q.offer(new Bead(nRx, nRy, nBx, nBy, curCnt+1));
				}
				
			}
		}
		return;
	}
}
