// 2022-10-07
// 다리만들기 2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node> {
		int from;
		int to;
		int bridgeLen;
		
		public Node(int from, int to, int bridgeLen) {
			this.from = from;
			this.to = to;
			this.bridgeLen = bridgeLen;
		}

		@Override
		public int compareTo(Node o) {
			return this.bridgeLen - o.bridgeLen; // 다리길이 작은것부터 큰 순으로
		}
	}
	static int N,M, landCnt;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static int[] parent;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		
		// 지도 그리기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 땅 구분짓기
		landCnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					landCnt++;
					makeLand(i,j);
				}
			}
		}
		
		// 다리 만들기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]!=0) {
					makeBridge(i,j,map[i][j]);
				}
			}
		}
		
		// 최소 다리길이 찾기(크루스칼 알고리즘)
		parent = new int [landCnt+1];
		for(int i=1; i<=landCnt; i++) {
			parent[i] = i; // 부모 초기화
		}
		int answer = MST();
		if(answer == 0) answer = -1;
		
		System.out.println(answer);
	}
	
	private static int MST() { // 최소신장트리
		int sum = 0;
		int size = pq.size(); //다리 개수 만큼
		
		for(int i=0; i<size; i++) {
			Node node = pq.poll();
			int x = node.from;
			int y = node.to;
			
			if(find(x)!=find(y)) { // 부모가 서로 다르다면
				sum+=node.bridgeLen;
				union(x,y);
			}
		}
		
		int root = parent[1];
		for(int i=1; i<parent.length; i++) {
			if(root != find(parent[i])) return 0; // 부모가 하나로 전부 통합이 안되면 다리 연결 안된거
		}
		return sum;
	}

	private static void union(int x, int y) { //합치기
		int aRoot = find(x);
		int bRoot = find(y);
		
		if(aRoot<bRoot) {
			parent[bRoot] = aRoot;
		} else {
			parent[aRoot] = bRoot;
		}
		
	}

	private static int find(int n) {
		if(parent[n]==n) return n; //인덱스의 부모가 자기자신이라면 자기자신을 반환
		else return find(parent[n]); // 아니면 부모를 찾는다.
	}

	// 다리만들기
	private static void makeBridge(int i, int j, int land) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean [N][M];
		
		for(int d=0; d<4; d++) { // 한방향으로 가기 위함

			visited[i][j] = true;
			q.offer(new int[] {i,j,0});
			
			while(!q.isEmpty()) {
				
				int[] p = q.poll();
				int nx = p[0]+dx[d];
				int ny = p[1]+dy[d];
				
				if(isValid(nx,ny) && !visited[nx][ny] && map[nx][ny]!=land) {
					// 지도 안이고 한번도 방문하지 않은 곳이고 본인 땅이 아니면
					if(map[nx][ny] == 0) { // 바다면
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny,p[2]+1});
					} else { // 다른 땅을 발견했으면
						if(p[2]>1) { // 근데 다리길이가 2이상이면 통과
							pq.offer(new Node(land-1, map[nx][ny]-1, p[2]));
							break;
						}
					}
				}
				
			}
			q.clear(); // 다음 방향을 계산하기 위해
		}
	}

	// 땅 구분짓기
	private static void makeLand(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean [N][M];
		
		visited[i][j] = true;
		map[i][j] = landCnt+1;
		q.offer(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			int curX = p[0];
			int curY = p[1];
			
			for(int d=0; d<4; d++) {
				
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				
				if(isValid(nx,ny) && !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					map[nx][ny] = landCnt+1;
					q.offer(new int[] {nx,ny});
				}
			}
			
		}
	}

	// 유효성 체크
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<N && ny<M) return true;
		else return false;
	}
	

}
