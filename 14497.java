// 2022-10-27
// 주난의 난

import java.io.*;
import java.util.*;
public class Main {
	
	static class Point implements Comparable<Point> {
		
		int curX;
		int curY;
		int time;
		
		public Point (int curX, int curY, int time) {
			this.curX = curX;
			this.curY = curY;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
			return this.time - o.time;
		}
		
	}

	static int N,M;
	static int x1,y1,x2,y2;
	static int[][] map, temp;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int ans;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		
		map = new int [N+1][M+1];
		temp = new int [N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String str = in.readLine();
			for(int j=1; j<=M; j++) {
				char ch = str.charAt(j-1);
				if(ch == '1') map[i][j] = 1; // 학생
				else if(ch == '0') map[i][j] = 0; // 빈공간
				else if(ch == '*') map[i][j] = 2; // 주난이
				else map[i][j] = 9; // 초코바 훔친 범인
			}
		}
		
		BFS(x1, y1);
	}
	private static void BFS(int x, int y) {
		
    // 걸리는 시간을 오름차순으로 정렬하여 탐색하여야 한다.
    // 예를 들어 시간이 2가 걸린 좌표와 1이 걸린 좌표가 들어있는데
    // 2가 걸린 좌표가 먼저 poll()이 되어버리는 경우 3으로 갱신되면 방문체크가 완료되게 된다.
    // 원래는 시간이 1이 걸린 좌표가 먼저 poll()이 되어 방문되어야 최소 시간을 구할 수 있게 된다.
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean [N+1][M+1];
		
		pq.offer(new Point(x, y, 0));
		visited[x][y] = true;
		
		while(!pq.isEmpty()) {
			
			Point p = pq.poll();
			
			if((p.curX == x2) && (p.curY == y2)) {
				System.out.println(p.time);
				return;
			}
			
			
			for(int i=0; i<4; i++) {
				int nx = p.curX + dx[i];
				int ny = p.curY + dy[i];
				
				if(isValid(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if (map[nx][ny]==0) {
						pq.offer(new Point(nx,ny,p.time));
					} else {
						map[nx][ny] = 0;
						pq.offer(new Point(nx,ny,p.time+1));
					}
				}
				
			}
		}
		
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>0 && ny>0 && nx<=N && ny<=M) return true;
		return false;
	}
}
