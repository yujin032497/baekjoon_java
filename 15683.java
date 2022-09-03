// 2022-09-03
// 감시

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static class CCTV {
		int x;
		int y;
		
		public CCTV (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M;
	static int[] dx = {-1, 0, 1, 0}; //상우좌상
	static int[] dy = {0, 1, 0, -1};
	static ArrayList<CCTV> cctvs;
	static int ans;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int [N][M];
	
		cctvs = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0 && map[i][j]!=6) {
					cctvs.add(new CCTV(i,j));
				}
			}
		}
		
		DFS(0, map);
		System.out.println(ans);
	}
	private static void DFS(int depth, int[][] map) {
		
		if(depth==cctvs.size()) {
			int count = zeroCnt(map);
			ans = Math.min(ans, count);
			return;
		}
		
		int curX = cctvs.get(depth).x;
		int curY = cctvs.get(depth).y;
		int type = map[curX][curY];
		int [][] copyMap;
		
		if(type==1) {
			
			copyMap = copy(map);
			searchTop(curX, curY, copyMap);
			DFS(depth+1, copyMap);
			
			copyMap = copy(map);
			searchRight(curX, curY, copyMap);
			DFS(depth+1, copyMap);
			
			copyMap = copy(map);
			searchBottom(curX, curY, copyMap);
			DFS(depth+1, copyMap);
			
			copyMap = copy(map);
			searchLeft(curX, curY, copyMap);
			DFS(depth+1, copyMap);
			
		} else if(type==2) {
			copyMap = copy(map);
			searchTop(curX, curY, copyMap);
			searchBottom(curX, curY, copyMap);
			DFS(depth+1, copyMap);
			
			copyMap = copy(map);
			searchLeft(curX, curY, copyMap);
			searchRight(curX, curY, copyMap);
			DFS(depth+1, copyMap);
			
		} else if(type==3) {
			copyMap = copy(map);
			searchTop(curX, curY, copyMap);
			searchRight(curX, curY, copyMap);
			DFS(depth+1, copyMap);
			
			copyMap = copy(map);
			searchRight(curX, curY, copyMap);
			searchBottom(curX, curY, copyMap);
			DFS(depth+1, copyMap);
			
			copyMap = copy(map);
			searchBottom(curX, curY, copyMap);
			searchLeft(curX, curY, copyMap);
			DFS(depth+1, copyMap);
			
			copyMap = copy(map);
			searchLeft(curX, curY, copyMap);
			searchTop(curX, curY, copyMap);
			DFS(depth+1, copyMap);
		
		} else if(type==4) {
			copyMap = copy(map);
			searchLeft(curX, curY, copyMap);
			searchTop(curX, curY, copyMap);
			searchRight(curX, curY, copyMap);
			DFS(depth+1, copyMap);
			
			copyMap = copy(map);
			searchTop(curX, curY, copyMap);
			searchRight(curX, curY, copyMap);
			searchBottom(curX, curY, copyMap);
			DFS(depth+1, copyMap);
			
			copyMap = copy(map);
			searchRight(curX, curY, copyMap);
			searchBottom(curX, curY, copyMap);
			searchLeft(curX, curY, copyMap);
			DFS(depth+1, copyMap);
			
			copyMap = copy(map);
			searchBottom(curX, curY, copyMap);
			searchLeft(curX, curY, copyMap);
			searchTop(curX, curY, copyMap);
			DFS(depth+1, copyMap);
			
		} else if(type==5) {
			copyMap = copy(map);
			searchTop(curX, curY, copyMap);
			searchRight(curX, curY, copyMap);
			searchBottom(curX, curY, copyMap);
			searchLeft(curX, curY, copyMap);
			DFS(depth+1, copyMap);
		}
		
	}
	
	private static int zeroCnt(int[][] map) {
		int tmp = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					tmp+=1;
				}
			}
		}
		
		return tmp;
	}
	private static int[][] copy(int[][] map) {
		int [][] tmp = new int [N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		return tmp;
	}
	private static void searchTop(int x, int y, int[][] map) {
		for(int i=x; i>=0; i--) {
			if(map[i][y]==6) return; // 벽을 만나면
			if(map[i][y]!=0) continue; // 감시카메라 만나거나 이미 감시한 칸이면
			map[i][y] = 9;
		}
	}
	
	private static void searchRight(int x, int y, int[][] map) {
		for(int i=y; i<M; i++) {
			if(map[x][i]==6) return; // 벽을 만나면
			if(map[x][i]!=0) continue; // 감시카메라 만나거나 이미 감시한 칸이면
			map[x][i] = 9;
		}
	}
	
	private static void searchBottom(int x, int y, int[][] map) {
		for(int i=x; i<N; i++) {
			if(map[i][y]==6) return; // 벽을 만나면
			if(map[i][y]!=0) continue; // 감시카메라 만나거나 이미 감시한 칸이면
			map[i][y] = 9;
		}
	}
	
	private static void searchLeft(int x, int y, int[][] map) {
		for(int i=y; i>=0; i--) {
			if(map[x][i]==6) return; // 벽을 만나면
			if(map[x][i]!=0) continue; // 감시카메라 만나거나 이미 감시한 칸이면
			map[x][i] = 9;
		}
	}
}
