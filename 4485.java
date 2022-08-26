// 2022-08-26
// 녹색 옷 입은 애가 젤다지?

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	static int[] dy = {0, 0, -1, 1};
	static int[][] distance;
	static boolean [][] visited;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = 1;
		while(true) {
			
			N = Integer.parseInt(in.readLine());
			if(N==0) break;
			
			sb.append("Problem "+TC+": ");
			
			map = new int [N][N];
			visited = new boolean [N][N];
			distance = new int [N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			distance[0][0] = map[0][0]; //출발점
			pq.add(new Edge(0,0,map[0][0]));
			
			while(!pq.isEmpty()) {
				
				Edge current = pq.poll();
				int c_x = current.x;
				int c_y = current.y;
				if (visited[c_x][c_y]) continue;
				visited[c_x][c_y] = true;
				
				for(int i=0; i<4; i++) {
					int nx = c_x+dx[i];
					int ny = c_y+dy[i];
					
					if(nx>=0 && ny>=0 && nx<N && ny<N) {
						if(distance[nx][ny] > distance[c_x][c_y]+map[nx][ny]) {
							distance[nx][ny] = distance[c_x][c_y]+map[nx][ny];
							pq.add(new Edge(nx,ny,distance[nx][ny]));
						}
					}
				}
			}
			
			sb.append(distance[N-1][N-1]).append("\n");
			TC++;
			
		}
		
		System.out.println(sb);
	}
	
}
class Edge implements Comparable<Edge> {

	int x;
	int y;
	int value;
	
	public Edge() {};
	public Edge(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}
	@Override
	public int compareTo(Edge o) {
		if(this.value - o.value > 0) return 1;
		else return -1;
	}
	
}
