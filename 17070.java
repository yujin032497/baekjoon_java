// 2022-08-27
// 파이프 옮기기 1

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	
	static int statePipe = -1; //0: 가로, 1: 세로, 2: 대각선
	static int [][] dx = {{0,1},{1,1},{0,1,1}};
	static int [][] dy = {{1,1},{0,1},{1,0,1}};
	static int N;
	static int [][] map;
	static int count = 0;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		map = new int [N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기상태
		map[1][1]=2;
		map[1][2]=2;
		statePipe = 0;
		
		dfs(1,2);
		System.out.println(count);
		
	}
	private static void dfs(int x, int y) {
		
		if(x==N & y==N) {
			count++;
			return;
		}
		
		if(statePipe==0) { //가로
			for(int i=0; i<2; i++) {
				int nx = x+dx[0][i];
				int ny = y+dy[0][i];
				
				if(isInBoundary(nx,ny) && map[nx][ny] == 0 ) {
					if(i==0) statePipe = 0;
					else if(i==1) {
						if(!pipeInBoundary(nx, ny)) continue;
						statePipe = 2;
					}
					
					map[nx][ny] = 2;
					dfs(nx,ny);
					map[nx][ny] = 0;
				}
			}
			
		} else if(statePipe==1) { //세로
			for(int i=0; i<2; i++) {
				int nx = x+dx[1][i];
				int ny = y+dy[1][i];
				
				if(isInBoundary(nx,ny) && map[nx][ny] == 0 ) {
					if(i==0) statePipe = 1;
					else if(i==1) {
						if(!pipeInBoundary(nx, ny)) continue;
						statePipe = 2;
					}
					
					map[nx][ny] = 2;
					dfs(nx,ny);
					map[nx][ny] = 0;
				}
			}
			
		} else if(statePipe==2) { //대각선
			for(int i=0; i<3; i++) {
				int nx = x+dx[2][i];
				int ny = y+dy[2][i];
				
				if(isInBoundary(nx,ny) && map[nx][ny] == 0 ) {
					if(i==0) statePipe = 0;
					else if(i==1) statePipe = 1;
					else if(i==2) {
						if(!pipeInBoundary(nx, ny)) continue;
						statePipe = 2;
					}
					
					map[nx][ny] = 2;
					dfs(nx,ny);
					map[nx][ny] = 0;
				}
			}
		}
		map[x][y]=0;
	}
	private static boolean pipeInBoundary(int nx, int ny) {

		if(map[nx][ny]!=1 && map[nx-1][ny]!=1 && map[nx][ny-1]!=1) return true;
		return false;
	}
	private static boolean isInBoundary(int nx, int ny) {
		if(nx>=1 && ny>=1 && nx<=N && ny<=N) return true;
		else return false;
	}

}
