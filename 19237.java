// 2022-11-07
// 어른 상어

import java.io.*;
import java.util.*;
public class Main {
	
	static class Shark implements Comparable<Shark>{
		int n;
		int x;
		int y;
		int curDirect;
		int d[][];
		
		public Shark(int n, int x, int y, int curDirect, int[][] d ) {
			this.n = n;
			this.x = x;
			this.y = y;
			this.curDirect = curDirect;
			this.d = d;
		}

		@Override
		public int compareTo(Shark o) {
			return this.n - o.n;
		}
	}
	
	static class Small {
		int n;
		int sCnt;
		
		public Small(int n, int sCnt) {
			this.n = n;
			this.sCnt = sCnt;
		}
	}
	static int N,M,K;
	static int [][] map;
	static Small[][] state;
	static int[] dx = {0,-1,1,0,0}; // 위, 아래, 왼쪽, 오른쪽
	static int[] dy = {0,0,0,-1,1};
	static ArrayList<Shark> sharks;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken()); // NXN
		M = Integer.parseInt(st.nextToken()); // M 마리 상어
		K = Integer.parseInt(st.nextToken()); // K번 움직일 때 냄새 사라짐
		
		map = new int [N+1][N+1];
		state = new Small[N+1][N+1];
		sharks = new ArrayList<>();
		
		// 맵 그리기
		for(int i=1; i<=N; i++) { 
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] !=0 ) { 
					sharks.add(new Shark(map[i][j], i, j, 0, new int [5][5]));  // 상어 번호 매기기
					state[i][j] = new Small(map[i][j], K);
				}
			}
		}
		
		Collections.sort(sharks);
		
		// 상어가 맨 처음 보는 방향 설정
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<M; i++) {
			sharks.get(i).curDirect = Integer.parseInt(st.nextToken());
		}
		
		// 상어 우선순위 방향 초기화
		for(int i=0; i<M; i++) {
			for(int j=1; j<=4; j++) {
				st = new StringTokenizer(in.readLine());
				for(int k=1; k<=4; k++) {
					sharks.get(i).d[j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		System.out.println(Simulate());
		
	}
	private static int Simulate() {
		int time = 0;
		
		while(true) {
			time++;
			
			if(time > 1000) return -1; // 시간이 1000넘으면 종료
			
			// 1. 상어가 움직인다.
			for(int i=0; i<sharks.size(); i++) {
				int n = sharks.get(i).n; // 현재 탐색하는 상어 번호
				int curX = sharks.get(i).x; // 현재 상어 X좌표
				int curY = sharks.get(i).y; // 현재 상어 Y좌표
				int curDirect = sharks.get(i).curDirect; // 현재 상어의 처음본 방향
				int tmpX = 0, tmpY = 0, tmpD = 0;
				boolean isMove = false, isMy = false;
				// 상어가 처음 본 방향에 대한 우선순위 4방탐색
				for(int j=1; j<=4; j++) {
					
					int nx = curX + dx[sharks.get(i).d[curDirect][j]]; // 앞으로 나아갈 좌표
					int ny = curY + dy[sharks.get(i).d[curDirect][j]];
					
					if(isValid(nx,ny)) {
						if(state[nx][ny]!=null) { // 빈칸이 아닌데
							if(state[nx][ny].n==n && !isMy) { // 자기가 뿌린 냄새칸이라면 
								tmpX = nx; // 우선은 저장한다.
								tmpY = ny;
								tmpD = sharks.get(i).d[curDirect][j];
								isMy = true; // 제일 먼저 발견한 자기가 뿌린 냄새칸
							} else continue;
						} else { // 빈칸이라면 
							curX = nx;
							curY = ny;
							curDirect = sharks.get(i).d[curDirect][j]; // 앞으로 볼 방향이 다음에 탐색할 방향임
							isMove = true;
							break;
						}
					}
					
				}
				
				if(!isMove) { // 움직이려는 빈칸을 찾지 못했다면
					curX = tmpX; // 자기가 뿌린 냄새칸 중에 제일 먼저 발견한 칸으로 이동
					curY = tmpY;
					curDirect = tmpD;
				}
				
				sharks.get(i).x = curX; // 최종적으로 상어 좌표와 보는 방향 서정
				sharks.get(i).y = curY;
				sharks.get(i).curDirect = curDirect;
			}
			
			// 2. 냄새칸에서 냄새가 1 사라진다.
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(state[i][j]!=null) {
						state[i][j].sCnt-=1;
						if(state[i][j].sCnt==0) state[i][j] = null;
					}
				}
			}
			
			// 3. 같은 칸에 상어가 있는지 검사한다.
			for(int i=0; i<sharks.size()-1; i++) {
				for(int j=i+1; j<sharks.size(); j++) {
					// 서로 같은 좌표에 있으면
					if(sharks.get(i).x == sharks.get(j).x && sharks.get(i).y == sharks.get(j).y) {
						if(sharks.get(i).n < sharks.get(j).n) { // 번호가 큰 쪽이 튕겨져 나간다.
							sharks.remove(j);
							j--;
						} else if(sharks.get(i).n > sharks.get(j).n) {
							sharks.remove(i);
							i--;
						}
					}
				}
			}
			
			// 남은 상어의 좌표에 냄새를 심어준다.
			for(int i=0; i<sharks.size(); i++) {
				int x = sharks.get(i).x;
				int y = sharks.get(i).y;
				int n = sharks.get(i).n;
				
				if(state[x][y]!=null) {
					state[x][y].n = n;
					state[x][y].sCnt = K;
				} else {
					state[x][y] = new Small(n,K);
				}
			}
			
			if(sharks.size()==1) return time;
		}
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>0 && ny>0 && nx<=N && ny<=N) return true;
		return false;
	}

}
