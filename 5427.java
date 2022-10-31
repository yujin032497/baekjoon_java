// 2022-10-31
// 불

import java.io.*;
import java.util.*;
public class Main {

	static int W,H;
	static char[][] map;
	static ArrayDeque<int[]> q;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int time;
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			st = new StringTokenizer(in.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new char [H][W];
			q = new ArrayDeque<>();
			
			int sangX=-1, sangY=-1;
			for(int i=0; i<H; i++) {
				String str = in.readLine();
				for(int j=0; j<W; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='*') q.offer(new int[] {i,j,1,0}); // 불 먼저 큐엥 삽입
					else if(map[i][j]=='@') {
						sangX = i; // 상근이의 위치
						sangY = j;
					}
				}
			}
			
			q.offer(new int[] {sangX, sangY,2,0}); // 불 위치를 우선적으로 큐에 삽입한 다음 상근이 위치를 큐에 삽입
			
			time = 0; // 탈출하는데 걸리는 시간
			BFS(); // 상근이의 탈출 시뮬레이션
			
			if(time==0) sb.append("IMPOSSIBLE").append("\n");
			else sb.append(time).append("\n");
		}
		System.out.println(sb);
	}
	private static void BFS() {
		
		while(!q.isEmpty()) {
			
			int [] p = q.poll();
			
			int curX = p[0];
			int curY = p[1];
			int type = p[2];
			
			
			for(int i=0; i<4; i++) {
				
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(!isValid(nx,ny) && type==2) {
					time = p[3]+1;
					return;// 상근이라면 탈출!
				}
				
				if(isValid(nx,ny) && map[nx][ny]!='#') { // 배열 경계안이고 벽이 아니라면
					if(type==1 && map[nx][ny]!='*') { // 이미 옮겨 붙은 칸이 아니거나 불이라면
						map[nx][ny] = '*';
						q.offer(new int[] {nx,ny,1,p[3]+1});
					} else { //상근이라면
						if(map[nx][ny]=='.') { // 불도 붙지 않고 벽도 없는 빈 공간이라면
							map[nx][ny] = '@';
							q.offer(new int[] {nx,ny,2,p[3]+1});
						}
					}
				}
				
			}
			
			
		}
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<H && ny<W) return true;
		return false;
	}
}
