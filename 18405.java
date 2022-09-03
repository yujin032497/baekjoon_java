// 2022-09-04
// 경쟁적 전염

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Virus implements Comparable<Virus> {
		int x;
		int y;
		int num;
		
		public Virus(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}

		@Override
		public int compareTo(Virus o) {
			return this.num >= o.num ? 1 : -1;
		}
	}

	static int N, K;
	static int S, X, Y;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static PriorityQueue<Virus> pq;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int [N+1][N+1];
		visited = new boolean [N+1][N+1];
		pq = new PriorityQueue<Virus>();
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) pq.offer(new Virus(i,j,map[i][j]));
			
			}
		}
		
		st = new StringTokenizer(in.readLine());
		
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		BFS();
		
		System.out.println(map[X][Y]);
	}
	private static void BFS() {
		int time = 0;
		while(time<S) {
			Queue<Virus> q = new ArrayDeque<>();
			for(int i=0; i<pq.size(); i++) {
				q.add(pq.poll());
				i--;
			}
			pq.clear();
			int len = q.size();
			for(int l=0; l<len; l++) {
				Virus v = q.poll();
				int curX = v.x;
				int curY = v.y;
				int num = v.num;
				
				for(int i=0; i<4; i++) {
					
					int nx = curX + dx[i];
					int ny = curY + dy[i];
					
					if(isValid(nx,ny) && map[nx][ny]==0) {
						map[nx][ny] = num;
						pq.offer(new Virus(nx,ny,num));
					}
				}
			}
			
		/*	System.out.println();
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}*/
			
			time+=1;
			
		}
		
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>=1 && ny>=1 && nx<=N && ny<=N) return true;
		else return false;
	}
}
