// 2022-08-24
// 적록색약

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static Queue<int[]> q = new LinkedList<>();
	static Queue<int[]> q2 = new LinkedList<>();
	static int N;
	static char [][] map;
	static boolean [][] visited, visited2;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int rgCnt = 0, rgbCnt=0;
	static char color, color2;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		map = new char [N][N];
		visited = new boolean [N][N];
		visited2 = new boolean [N][N];
		
		for(int i=0; i<N; i++) {
			String line = in.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					color = map[i][j];
					rgBfs(i,j);
					rgCnt++;
				}
				if(!visited2[i][j]) {
					color2 = map[i][j];
					rgbBfs(i,j);
					rgbCnt++;
				}
			}
		}
		
		System.out.println(rgbCnt+" "+rgCnt);
		
		
	}

	private static void rgBfs(int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y] = true;
		q.offer(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p[0]+dx[i];
				int ny = p[1]+dy[i];
				if(isInBound(nx,ny) && !visited[nx][ny]) {
					if(color=='R' || color == 'G') {
						if(map[nx][ny]=='R' || map[nx][ny]=='G') {
							rgBfs(nx,ny);
						} 
					} else if (color=='B') {
						if(map[nx][ny]=='B') {
							rgBfs(nx,ny);
						}
					}
				}
			}
		}
	}
	
	private static void rgbBfs(int x, int y) {
		// TODO Auto-generated method stub
		visited2[x][y] = true;
		q2.offer(new int[] {x, y});
		
		while(!q2.isEmpty()) {
			int[] p = q2.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p[0]+dx[i];
				int ny = p[1]+dy[i];
				if(isInBound(nx,ny) && !visited2[nx][ny]) {
					if(color2 == map[nx][ny]) {
						rgbBfs(nx,ny);	
					}
				}
			}
		}
	}
	
	private static boolean isInBound(int nx, int ny) {
		if(nx>=0 && ny >=0 && nx<N && ny<N) return true;
		else return false;
	}

}
