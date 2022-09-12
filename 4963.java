// 2022-09-12
// 섬의 개수

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon4963 {
	
	static int w,h;
	static int [] dx = {-1,-1,-1,0,1,1,1,0};
	static int [] dy = {-1,0,1,1,1,0,-1,-1};
	static int[][] map;
	static boolean[][] visited;
	static int landCnt;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		
			if(w==0 && h==0) break;
			
			map = new int [h][w];
			visited = new boolean [h][w];
			landCnt = 0;
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						BFS(i,j);
						landCnt+=1;
					}
				}
			}
			
			sb.append(landCnt).append("\n");
			
		}
		
		System.out.println(sb);
	}
	private static void BFS(int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			int curX = p[0];
			int curY = p[1];
			
			for(int i=0; i<8; i++) {
				
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(isValid(nx,ny) && !visited[nx][ny] && map[nx][ny]==1) {
					q.offer(new int[] {nx,ny});
					visited[nx][ny] = true;
				}
			}
		}
		
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<h && ny<w) return true;
		else return false;
	}

}
