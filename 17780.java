// 2022-11-06
// 새로운 게임

import java.io.*;
import java.util.*;

public class Main {
	static class Horse {
		int x;
		int y;
		int d;
		
		public Horse(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	static int N,K;
	static int[][] map;
	static int[] dx = { 0, 0, 0, -1, 1 }; // 우왼상하
	static int[] dy = { 0, 1, -1, 0, 0 };
	static ArrayList<Integer>[][] state;
	static Horse[] horses;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int [N+1][N+1];
		state = new ArrayList[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				state[i][j] = new ArrayList<>();
			}
		}
		
		horses = new Horse[K+1];
		for(int i=1; i<=K; i++) {
			st = new StringTokenizer(in.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			horses[i] = new Horse(x,y,d);
			state[x][y].add(i);
		}
		
		System.out.println(Simulate());
		
	}
	private static int Simulate() {
		boolean flag = true;
		int turn = 0;
		
		while(flag) {
			turn++;
			if(turn > 1000) break;
			
			for(int i=1; i<=K; i++) {
				Horse h = horses[i];
				int x = h.x;
				int y = h.y;
				
				// 가장 아래쪽 말이 아니면 넘긴다
				if(state[x][y].get(0)!=i) continue;
				
				// 가장 아래쪽에 있는 말부터 움직인다.
				int nx = x+dx[h.d];
				int ny = y+dy[h.d];
				
				// 말이 이동하려는 칸이 범위를 벗어나고 파란색칸이면
				if(!isValid(nx,ny) || map[nx][ny]==2) {
					if(h.d==1) h.d=2;
					else if(h.d==2) h.d=1;
					else if(h.d==3) h.d=4;
					else if(h.d==4) h.d=3;
					
					nx = x+dx[h.d];
					ny = y+dy[h.d];
				}
				
				if(!isValid(nx,ny) || map[nx][ny]==2) continue; // 방향을 바꾸고 파란색 칸이면 이동하지 않는다.
				else if(map[nx][ny] == 1) { // 이동하려는 칸이 빨간색이면
					
					for(int j=state[x][y].size()-1; j>=0; j--) { // 순서를 반대로 하여 이동한다.
						int tmp = state[x][y].get(j);
						state[nx][ny].add(tmp);
						horses[tmp].x = nx;
						horses[tmp].y = ny;
					}
					state[x][y].clear(); // 이전 리스트는 비운다.
				}
				else if(map[nx][ny] == 0) { // 흰색 칸이면 말을 이동한다.
					for(int j=0; j<state[x][y].size(); j++) {
						int tmp = state[x][y].get(j);
						state[nx][ny].add(tmp);
						horses[tmp].x = nx;
						horses[tmp].y = ny;
					}
					state[x][y].clear(); // 이전 리스트는 비운다.
				}
				
				if(state[nx][ny].size()>=4) { // 말이 4개이상 존재하면 종료
					flag = false;
					break;
				}
			}
		}
		
		if(!flag) return turn;
		else return -1;
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>0 && ny>0 && nx<=N && ny<=N) return true;
		return false;
	}
}
