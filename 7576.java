// 2022-08-24
// 토마토

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static Queue<int[]> q = new LinkedList<>();
	static int N, M;
	static int[][] tomato;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int totCnt = 0, wanCnt = 0, noCnt = 0, day = 0;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		M = Integer.parseInt(split[0]);
		N = Integer.parseInt(split[1]);
		
		tomato = new int [N][M];
		totCnt = N*M;
		
		for(int i=0; i<N; i++) {
			split = in.readLine().split(" ");
			for(int j=0; j<M; j++) {
				tomato[i][j] = Integer.parseInt(split[j]);
				if(tomato[i][j] == 1) {
					wanCnt++;
					q.add(new int[] {i,j});
				}
				if(tomato[i][j] == 0) noCnt++;
				if(tomato[i][j] == -1) totCnt--;
			}
		}
		
		if(wanCnt==totCnt) System.out.println(0);
		else {
			bfs();
			if(wanCnt!=totCnt) System.out.println(-1);
			else System.out.println(day);
		}
	}
	private static void bfs() {
		
		while(!q.isEmpty()) {
			int len = q.size();
			boolean state = false;
			for(int l=0; l<len; l++) {
				int[] p = q.poll();
				
				for(int i=0; i<4; i++) {
					int nx = p[0]+dx[i];
					int ny = p[1]+dy[i];
					if(isInBound(nx,ny) && tomato[nx][ny] == 0) {
						tomato[nx][ny] = 1;
						wanCnt++;
						q.add(new int[] {nx,ny});
						state = true;
					}
				}	
			} 
			if(state) day++;
		}
	}
	private static boolean isInBound(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<N && ny<M) return true;
		return false;
	}
}
