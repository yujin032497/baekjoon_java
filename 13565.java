// 2022-08-31
// 침투

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1}; // 상하좌우
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		visited = new boolean [N][M];
		
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		boolean ans = false;
		
		for(int i=0; i<M; i++) {
			if(map[0][i]==0) {
				ans = DFS(0,i);
				if(ans==true) break;	
			}
		}
		
		if(ans==true) System.out.println("YES");
		else System.out.println("NO");
	}
	private static boolean DFS(int x, int y) {
		
		int curX = x; // 현재 위치
		int curY = y;
		
		if(visited[curX][curY]) return false;
		else{
			if(curX==N-1) return true;
		}
		
		visited[curX][curY] = true;
		boolean rtn = false;
		
		for(int i=0; i<4; i++) {
			int nx = curX+dx[i];
			int ny = curY+dy[i];
			
			if(isValid(nx,ny) && map[nx][ny]==0) {
				rtn = DFS(nx,ny);
				if(rtn == true) return true;
			}
		}
		
		return false;
	}
	private static boolean isValid(int nx, int ny) {
		if(nx<0 || ny<0 || nx>=N || ny>=M) return false;
		else return true;
	}

}
