// 2022-09-04
// 아기 상어

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon16236 {
	
	static int N;
	static int[][] map;
	static int sharkX, sharkY;
	static int answer=0, curSize=2, curEaten=0; //정답, 현재 상어사이즈, 현재 먹은 물고기 수
	static int fishCnt; // 맵에서 먹을 수 있는 물고기 수
	static int[] dx = {-1, 0, 1, 0}; //4방향 탐색
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		map = new int [N][N];
		fishCnt=0;
	
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) { // 9면 상어위치
					sharkX = i;
					sharkY = j;
					map[sharkX][sharkY] = 0;
				} else if(map[i][j]>0) fishCnt+=1; //0보다 크면 물고기
			}
		}
		
		int temp;
		
		while(fishCnt!=0) {
			
			temp = fishCnt; //현재 맵에서 먹을 수 있는 물고기 수
			bfs();
			if(temp==fishCnt) break; // 탐색했는데 같으면 더 이상 먹을 수 있는 물고기 
		}
		
		System.out.println(answer);
		
	}
	
	private static void bfs() {
		int x, y, nx, ny, depth;
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {sharkX, sharkY, 1}); // 현재 상어위치부터 시작
		visited[sharkX][sharkY] = true; //현재 상어위치 방문 처리
		int nextX = -1, nextY = -1, nextDepth = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			x = temp[0];
			y = temp[1];
			depth = temp[2]; // 깊이 1부터 탐색
			
			if(nextDepth<depth) break; // 거리짧은것부터
			for(int i=0; i<4; i++) { // 4방탐색
				nx = x+dx[i];
				ny = y+dy[i];
				
				if(isValid(nx,ny) && !visited[nx][ny] && map[nx][ny]<= curSize) { // 맵 범위 벗어나지 않았고, 방문 안했고, 현재 상어사이즈보다 값이 작으면
					
					if(map[nx][ny]>0 && curSize>map[nx][ny]) { // 맵에서 0보다 크고 현재 상어사이즈보다 작으면(먹을 수 있는 물고기) 0이면 다음방문으로
						if(nextX==-1) { // 처음 물고기 탐색이라면
							nextX=nx;
							nextY=ny;
							nextDepth=depth;
						}	
						else { // 이미 물고기 탐색했다면
							if(nextX>nx) { // 가장 위에 있는 물고기
								nextX=nx;
								nextY=ny;
							} else if(nextX==nx) { // 가장 왼쪽에 있는 물고기
								if(nextY>ny) {
									nextX=nx;
									nextY=ny;
								}
							}
						}
					} 
					visited[nx][ny] = true;
					q.offer(new int[] {nx,ny,depth+1}); // 다음깊이 탐색
				}
			}
		}
		if(nextX!=-1) { // 먹을 수 있는 물고기가 있다면
			map[nextX][nextY]=0; // 먹는다.
			answer+=nextDepth; //거리더하기
			fishCnt--; // 맵의 물고기 수 줄어듬
			sharkX = nextX; //상어 위치 바꾼다.
			sharkY = nextY;
			curEaten++; // 먹은 물고기 수 1증가
			if(curEaten==curSize) { // 먹은 물고기 수 = 상어사이즈
				curEaten=0; // 먹은 물고기 수 초기화
				curSize++; // 상어사이즈 업
			}
		}
	}

	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny >=0 && nx < N && ny < N) return true;
		else return false;
	}

}
