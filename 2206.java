// 2022-09-09
// 벽 부수고 이동하기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map;
	static boolean [][][] visited;
	static boolean isBroken;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		visited = new boolean [2][N][M];
		isBroken = false;
		
		for(int i=0; i<N; i++) {
			String line = in.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		
		BFS(0,0);
		if(ans==0) ans = -1;
		System.out.println(ans);
	}
	private static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited[0][x][y] = true;
		q.offer(new int[] {x,y,1,0});
		
		while(!q.isEmpty()) {
			
			int[] p = q.poll();
			
			int curX = p[0];
			int curY = p[1];
			int curDepth = p[2];
			int isCrush = p[3]; // 0: 안부술때, 1:부술때
			
			if(curX==N-1 && curY==M-1) {
				ans = curDepth;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(!isValid(nx,ny)) continue;
				
				if(map[nx][ny] == 1) {
					if(isCrush==0 && !visited[1][nx][ny]) {
						visited[1][nx][ny] = true;
						q.offer(new int [] {nx,ny,curDepth+1,1});
					}
						
				} else {
					if(!visited[isCrush][nx][ny]) {
						visited[isCrush][nx][ny] = true;
						q.offer(new int [] {nx,ny,curDepth+1,isCrush});
					}
				}
			}
		}
	}
	
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<N && ny<M) return true;
		else return false;
	}

}
