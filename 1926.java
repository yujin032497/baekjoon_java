// 2022-09-14
// 그림

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int ans, cnt;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		visited = new boolean[N][M];
		ans = Integer.MIN_VALUE;
		cnt = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					BFS(i,j);
					cnt+=1;
				}
			}
		}
		
		System.out.println(cnt);
		if(ans==Integer.MIN_VALUE) ans = 0;
		System.out.println(ans);
	}
	private static void BFS(int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		
		
		int size = 0;
		
		q.offer(new int[] {x,y});
		visited[x][y] = true;
		size+=1;
		
		while(!q.isEmpty()) {
			
			int [] p = q.poll();
			
			int curX = p[0];
			int curY = p[1];
			
			for(int i=0; i<4; i++) {
				
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(isValid(nx,ny) && !visited[nx][ny]) {
					if(map[nx][ny]==1) {
						visited[nx][ny] = true;
						size +=1;
						q.add(new int[] {nx,ny});
					}
				}
			}
		}
		
		ans = Math.max(ans, size);
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<N && ny<M) return true;
		return false;
	}

}
