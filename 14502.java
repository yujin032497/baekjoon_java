// 2022-08-27
// 연구소

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[][] map;
	static int[] dx = {-1,1,0,0}; //상하좌우
	static int[] dy = {0,0,-1,1};
	static Queue<int[]> q = new LinkedList<>();
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(ans);
	}
	private static void dfs(int depth) {
	
		if(depth==3) {
			birus();
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					dfs(depth+1);
					map[i][j]=0;
				}
			}
		}
	}
	private static void birus() {
		
		int[][] copyMap = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copyMap[i][j] = map[i][j];
				if(copyMap[i][j]==2) q.add(new int[] {i,j});
			}
		}
		while(!q.isEmpty()) {
			int[] birus = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = birus[0]+dx[i];
				int ny = birus[1]+dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && copyMap[nx][ny]==0){
					copyMap[nx][ny] = 2;
					q.add(new int[] {nx,ny});
				}
			}
		}
		
		int blank = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copyMap[i][j]==0) blank+=1;
			}
		}
		ans = Math.max(ans, blank);
		
	}
}

