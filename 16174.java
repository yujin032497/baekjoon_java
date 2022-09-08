// 2022-09-08
// 점프왕 쩰리 (Large)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {0, 1};
	static int [] dy = {1, 0}; 
	static String ans;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		map = new int [N][N];
		visited = new boolean [N][N];
		ans = "";
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		simulate(0,0);
		if(ans=="") ans = "Hing";
		System.out.println(ans);
	}
	private static void simulate(int x, int y) {
		
		int curX = x;
		int curY = y;
		
		int moveCnt = map[x][y];
		if(map[x][y]==-1) ans = "HaruHaru";
		
		visited[curX][curY] = true;
		
		for(int i=0; i<2; i++) {
			int nx = curX + dx[i]*moveCnt;
			int ny = curY + dy[i]*moveCnt;
			
			if(isValid(nx,ny) && !visited[nx][ny]) {
				simulate(nx,ny);
			}
		}
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<N && ny<N) return true;
		else return false;
	}

}
