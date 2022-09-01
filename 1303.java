// 2022-09-01
// 전쟁 - 전투

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static char [][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0}; //상하좌우
	static int[] dy = {0,0,-1,1};
	static char curTeam;
	static int count;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char [M][N];
		visited = new boolean [M][N];
		int wPower = 0;
		int bPower = 0;
		
		for(int i=0; i<M; i++) {
			String str = in.readLine();
			map[i] = str.toCharArray();
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) continue;
				curTeam = map[i][j];
				count=0;
				DFS(i,j);
				
				if(curTeam=='W') {
					wPower += (count*count);
				} else {
					bPower += (count*count);
				}
			}
		}
		System.out.println(wPower+" "+bPower);
	}
	private static void DFS(int x, int y) {
		
		int curX = x;
		int curY = y;
		visited[curX][curY] = true;
		count+=1;
		
		for(int i=0; i<4; i++) {
			int nx = curX + dx[i];
			int ny = curY + dy[i];
			
			if(isValid(nx,ny) && !visited[nx][ny] && map[nx][ny]==curTeam) {
				DFS(nx, ny);
			}
		}
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<M && ny<N) return true;
		else return false;
	}

}
