// 2022-08-18
// 유기농 배추

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int M;
	static int N;
	static int K;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			String[] split = in.readLine().split(" ");
			M = Integer.parseInt(split[0]);
			N = Integer.parseInt(split[1]);
			K = Integer.parseInt(split[2]);
			
			map = new int [N][M];
			boolean[][] visited = new boolean [N][M];
			
			for(int i=0; i<K; i++) {
				split = in.readLine().split(" ");
				int y = Integer.parseInt(split[0]);
				int x = Integer.parseInt(split[1]);
				
				map[x][y] = 1;
			}
			
			int count = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						bfs(i,j, visited);
						count++;
					}
				}
			}
			
			System.out.println(count);
			
		}
	}

	private static void bfs(int i, int j, boolean[][] visited) {
		// TODO Auto-generated method stub
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i,j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int [] now = q.poll();
			for(int k=0; k<4; k++) {
				int x = now[0]+dx[k];
				int y = now[1]+dy[k];
				
				if(x>=0 && y>=0 && x<N && y<M) {
					if(!visited[x][y] && map[x][y] == 1) {
						visited[x][y] = true;
						q.offer(new int[] {x,y});
					}
				}
			}
		}
	}

}
