// 2022-09-01
// 컴백홈

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, K;
	static char [][] map; // 맵
	static boolean [][] visited; // 방문 배열
	static int [] dx = {-1, 1, 0, 0}; //상하좌우
	static int [] dy = {0, 0, -1, 1};
	static int ans;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char [R][C];
		visited = new boolean [R][C];
		ans = 0;
		
		for(int i=0; i<R; i++) {
			String str = in.readLine();
			map[i] = str.toCharArray();
		}
		
		DFS(1,R-1,0); //왼쪽 아랫점부터 시작
		System.out.println(ans);
	}
	private static void DFS(int depth, int x, int y) {
		
		// 현재 위치 좌표
		int curX = x;
		int curY = y;
		visited[curX][curY] = true;
		
		if(depth>K) return;
		if(depth==K && curX==0 && curY==C-1) {
			ans+=1;
			return;
		}
		
		for(int i=0; i<4; i++) {
			
			// 다음 위치로 갈 좌표
			int nx = curX + dx[i];
			int ny = curY + dy[i];
			
			// 좌표가 유효해야하고, 벽이 아니어야 하고, 아직 방문되지 않은 칸이면
			if(isValid(nx,ny) && map[nx][ny]!='T' && !visited[nx][ny]) {
				DFS(depth+1, nx, ny);
				visited[nx][ny] = false;
			}
		}
		
	}
	/**
	 * 좌표 유효성 검사
	 * @param nx
	 * @param ny
	 * @return
	 */
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<R && ny<C) return true;
		else return false;
	}

}
