// 2022-08-18
// 미로 탐색

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		map = new int [N][M];
		visited = new boolean [N][M];
		
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		bfs(0,0);
		System.out.println(map[N-1][M-1]);
	}

	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i,j});
		visited[i][j] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int k=0; k<4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if(x >=0 && y >= 0 && x < N && y < M) {
					if(map[x][y]!=0 && !visited[x][y]) {
						visited[x][y] = true;
						map[x][y] = map[now[0]][now[1]] + 1; // 깊이
						q.offer(new int[] {x,y});
					}
				}
			}
		
		}
	}
}
