// 2022-09-03
// 치즈

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean isCheese;
	static int ans;
	static ArrayList<Integer> count;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		count = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			isCheese = false;
			visited = new boolean [N][M];
			DFS(0,0);
			if(isCheese) {
				melt();	
				ans+=1;
			} else {
				break;
			}
			
/*			System.out.println();
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}*/
		}
		
		System.out.println(ans);
		System.out.println(count.get(count.size()-1));
	}
	private static void melt() {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j] && map[i][j]==1) {
					map[i][j] = 0;
					cnt+=1;
				}
			}
		}
		
		count.add(cnt);
	}
	private static void DFS(int x, int y) {
		
		int curX = x;
		int curY = y;
		visited[curX][curY] = true;
		
		for(int i=0; i<4; i++) {
			
			int nx = curX + dx[i];
			int ny = curY + dy[i];
			
			if(isValid(nx,ny) && !visited[nx][ny]) {
				if(map[nx][ny]==1) {
					visited[nx][ny] = true;
					isCheese = true;
				}
				else if(map[nx][ny]==0) {
					DFS(nx,ny);
				}
			}
		}
		
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<N && ny<M) return true;
		else return false;
	}

}
