// 2022-08-29
// 다리 만들기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int [][] map;
	static int landNum = 2;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int min;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		
		map = new int [N][N];
		
		// 지도 그리기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 땅 넘버링 다시 하기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1) {
					makeLand(i,j);
					landNum+=1;
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]!=0) BFS(i,j);
			}
		}
		
		System.out.println(min);
		
	}
	private static void BFS(int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		boolean [][] visited = new boolean [N][N];
		q.offer(new int[] {x,y,0});
		visited[x][y] = true;
		int curLand = map[x][y];
		
		while(!q.isEmpty()) {
			
			int[] p = q.poll();
			int curX = p[0];
			int curY = p[1];
			int distance = p[2];
			
			if(min<=distance) return;
			
			for(int i=0; i<4; i++) {
				int nx = curX+dx[i];
				int ny = curY+dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny]) {
					if(map[nx][ny]==0) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx,ny,distance+1});
					} else if(map[nx][ny]!=curLand) {
						min = Math.min(min, distance);
					}
				}
			}
		}
		
	}
	private static void makeLand(int x, int y) {
		
		int curX = x;
		int curY = y;
		map[curX][curY] = landNum;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny< N && map[nx][ny]==1) {
				makeLand(nx,ny);
			}
		}
		
	}

}
