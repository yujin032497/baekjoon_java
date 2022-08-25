// 2022-08-25
// 토마토

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N,M,H;
	static int[][][] tomato;
	static int totCnt = 0, wanCnt = 0, ripeCnt = 0; // 전체토마토, 익은토마토, 덜익은 토마토
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<int[]> q = new LinkedList<>();
	static int day;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		M = Integer.parseInt(split[0]);
		N = Integer.parseInt(split[1]);
		H = Integer.parseInt(split[2]);
		
		tomato = new int [H][N][M];
		//visited = new boolean[H][N][M];
		totCnt = H*N*M;
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				split = in.readLine().split(" ");
				for(int k=0; k<M; k++) {
					tomato[i][j][k] = Integer.parseInt(split[k]);
					if(tomato[i][j][k]==-1) totCnt--;
					else if(tomato[i][j][k]==1) {
						wanCnt++;
						q.offer(new int[] {i,j,k});
					}
				}
			}
		}
		
		if(totCnt==wanCnt) System.out.println(0);
		else {
			day = 0;
			bfs();
			if(wanCnt==totCnt) System.out.println(day);
			else System.out.println(-1);
		}
		
	}
	private static void bfs() {
		
		while(!q.isEmpty()) {
			int len = q.size();
			boolean state = false;
			
			for(int l=0; l<len; l++) {
				int[] p = q.poll();
				
				int h = p[0];
				int x = p[1];
				int y = p[2];
				
				for(int i=0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(isInBound(h, nx, ny) && tomato[h][nx][ny]==0) {
						tomato[h][nx][ny]=1;
						wanCnt++;
						q.offer(new int[] {h,nx,ny});
						state = true;
					}
				}
				
				if(isInBound(h-1, x, y) && tomato[h-1][x][y]==0) {
					tomato[h-1][x][y]=1;
					wanCnt++;
					q.offer(new int[] {h-1,x,y});
					state = true;
				}
				if(isInBound(h+1, x, y) && tomato[h+1][x][y]==0) {
					tomato[h+1][x][y]=1;
					wanCnt++;
					q.offer(new int[] {h+1,x,y});
					state = true;
				}
		
			}
			
			if(state) day++;
		}
		
	}
	private static boolean isInBound(int h, int x, int y) {
		if(x>=0 && y>=0 && h>=0 && x<N && y<M && h<H) return true;
		else return false;
	}

}
