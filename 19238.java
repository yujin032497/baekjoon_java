// 2022-11-08
// 스타트 택시
import java.io.*;
import java.util.*;

public class Main {
	
	static class Custom implements Comparable<Custom>{
		
		int sX; // 손님 출발 X좌표
		int sY; // 손님 출발 Y좌표
		int fX; // 손님 도착 X좌표
		int fY; // 손님 도착 Y좌표
		
		public Custom(int sX, int sY, int fX, int fY) {
			this.sX = sX;
			this.sY = sY;
			this.fX = fX;
			this.fY = fY;
		}

		@Override // 같은 거리의 손님일 경우 0과 1. 가까운 행 2. 가까운 열
		public int compareTo(Custom o) {
			if(this.sX == o.sX) { // 행이 같은 경우
				return this.sY - o.sY; // 열이 가까운 사람을 태운다.
			} else return this.sX - o.sX;
		}
	}
	
	static class Taxi {
		int x;
		int y;
		int gas;
		Custom custom;
		
		public Taxi(int x, int y, int gas, Custom custom) {
			this.x = x;
			this.y = y;
			this.gas = gas;
			this.custom = custom;
		}
	}
	
	static int N,M,K;
	static int [][] map;
	static Custom[][] state;
	static Taxi taxi;
	static int[] dx = {-1,0,1,0}; // 상왼하우
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken()); // N*N
		M = Integer.parseInt(st.nextToken()); // M명의 손님
		K = Integer.parseInt(st.nextToken()); // 초기의 택시 연료
		
		map = new int [N+1][N+1];
		state = new Custom [N+1][N+1]; // 손님 상태를 저장하는 배열
		
    // 맵 그리기
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(in.readLine());
		
		int taxiX = Integer.parseInt(st.nextToken()); // 택시 초기 X좌표
		int taxiY = Integer.parseInt(st.nextToken()); // 택시 초기 Y좌표
		
		taxi = new Taxi(taxiX, taxiY, K, null); // 택시 객체
		
    // M명의 손님만큼 손님 상태 배열에 저장
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int x = Integer.parseInt(st.nextToken()); // 손님 출발 X좌표
			int y = Integer.parseInt(st.nextToken()); // 손님 출발 Y좌표
			
			map[x][y] = 2; // 맵에 손님 표시
			
			int fx = Integer.parseInt(st.nextToken()); // 손님 도착 X좌표
			int fy = Integer.parseInt(st.nextToken()); // 손님 도착 Y좌표
			
			state[x][y] = new Custom(x,y,fx,fy); // 손님 상태배열에 손님 좌표를 저장하는 객체 저장
		}
		
		Simulate(); // 시뮬레이션 시작
		System.out.println(taxi.gas); // 시뮬레이션 후 택시의 연료 상태 출력
	}
	private static void Simulate() {
		
		// 1. 제일 가까운 손님을 찾아서 태운다.
		for(int i=0; i<M; i++) { // 손님 수 만큼 반복
			findCustom();
			if(taxi.custom==null || taxi.gas<=0) { // 손님을 안태웠거나 이미 연료를 다써버렸으면
				taxi.gas = -1; // 연료에 -1 저장
				return; // 시뮬레이션 종료
			}
      
      // 2. 택시가 손님을 태우고 목적지를 향한다.
			int useGas = moveTaxi(); // 택시가 손님을 태우고 사용한 연료를 반환
			if(taxi.custom!=null || taxi.gas<0) { // 손님을 못내렸거나 연료를 이상으로 썼다면
				taxi.gas = -1; // 연료에 -1 저장
				return; // 시뮬레이션 종료
			}
			
			taxi.gas += (useGas*2); // 손님을 태우고 사용한 연료 * 2 만큼 연료를 채운다.
		}
		
		return; // 손님을 목적지에 다 태워줬으면 시뮬레이션 종료
		
		
	}
  /* 손님을 태우고 택시가 이동*/
	private static int moveTaxi() {
		boolean[][] visited=  new boolean[N+1][N+1];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		int useGas = Integer.MAX_VALUE; // 가장 적게 사용한 연료
		boolean isArrive = false; // 도착했는지 체크
		visited[taxi.x][taxi.y] = true; // 현재 택시 위치를 방문 체크
		if(taxi.x == taxi.custom.fX && taxi.y == taxi.custom.fY) return 0; // 택시가 위치한 곳에 손님을 내려야 한다면 사용 연료 0을 반환
		
		q.offer(new int[] {taxi.x, taxi.y, 0});
		
		while(!q.isEmpty()) {
			
			int [] curTaxi = q.poll(); // 현재 택시 
			
			for(int i=0; i<4; i++) { // 4방탐색
				
				int nx = curTaxi[0] + dx[i]; // 택시가 다음 향할 X좌표
				int ny = curTaxi[1] + dy[i]; // 택시가 다음 향할 Y좌표
				
				if(isValid(nx,ny) && !visited[nx][ny] && map[nx][ny]!=1) { // 2-1. 배열 범위 안이고, 2-2. 방문을 안했고, 2-3. 벽이 아니라면
					visited[nx][ny] = true; // 방문을 체크하고
					if(taxi.custom.fX == nx && taxi.custom.fY == ny) { // 택시가 다음 향할 좌표에 손님을 내려야 한다면
						useGas = Math.min(useGas, curTaxi[2]+1); // 가장 작은 연료 저장
						isArrive = true; // 도착했다고 체크
					} else { // 손님을 내려야할 목적지가 아니면
						q.offer(new int[] {nx,ny,curTaxi[2]+1}); // 큐에 저장
					}
				}
			}
			
			if(isArrive) { // 손님을 내려줬다면
				taxi.x = taxi.custom.fX; // 내려준 택시 X좌표
				taxi.y = taxi.custom.fY; // 내려준 택시 Y좌표
				taxi.gas -= useGas; // 사용한 연료만큼 빼준다.
				taxi.custom = null; // 택시에서 손님이 내림;
				return useGas; // 사용한 연료 
			}
		}
		return 0;
		
	}
  /* 가까운 손님을 찾는다.*/
	private static void findCustom() {
		boolean[][] visited = new boolean[N+1][N+1];
		PriorityQueue<Custom> pq = new PriorityQueue<>(); // 같은 거리에 있을 때 1. 0에 가까운 행 2. 0에 가까운 열 순으로 손님을 저장
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		visited[taxi.x][taxi.y] = true; // 현재 택시 위치에 방문 체크
		if(map[taxi.x][taxi.y]==2) { // 현재 택시 위치에 손님이 있다면
			taxi.custom = state[taxi.x][taxi.y]; // 손님을 태우고
			map[taxi.x][taxi.y] = 0; // 맵에 손님표시를 없애고
			state[taxi.x][taxi.y] = null; // 상태맵에 손님을 제거한다.
			return; // 종료
		}
		
		q.offer(new int[] {taxi.x, taxi.y, 0});
		int useGas = 0; // 손님을 태우기 위해 사용한 연료
		while(!q.isEmpty()) {
			
			int len = q.size(); // 같은 거리에 있는 모든 손님을 찾기 위해 큐 배열에 있는 만큼 돌린다.
			for(int l=0; l<len; l++) {
				int[] curTaxi = q.poll(); // 현재 택시
				
				for(int i=0; i<4; i++) { // 4방 탐색
					
					int nx = curTaxi[0] + dx[i]; // 택시가 다음 향할 X좌표
					int ny = curTaxi[1] + dy[i]; // 택시가 다음 향할 Y좌표
					
					if(isValid(nx,ny) && !visited[nx][ny] && map[nx][ny]!=1) { // 1-1. 배열 범위 안이고, 1-2. 방문을 안했고, 1-3. 벽이 아니라면
						visited[nx][ny] = true; // 방문을 체크하고
						if(map[nx][ny]==2) { // 다음 향할 곳에 손님이 있다면
							pq.offer(state[nx][ny]); // 손님 우선큐에 넣고
							useGas = curTaxi[2]+1; // 사용한 가스를 저장 (같은 거리의 손님은 어차피 같은 연료를 사용하므로 상관X)
						} else { // 손님을 아직 만나지 못했다면
							q.offer(new int[] {nx,ny,curTaxi[2]+1}); // 큐에 저장
						}
					}
				}
			}
			
			if(!pq.isEmpty()) { // 손님 우선 큐에 비어있지 않으면 => 손님을 찾았다는 증거!
				Custom curCustom = pq.poll(); // 가장 최우선으로 태워야하는 손님을 꺼낸다.
				taxi.x = curCustom.sX; // 손님이 출발하는 위치 => 택시 현재 위치
				taxi.y = curCustom.sY;
				taxi.gas -= useGas; // 손님을 태우기 위한 사용 연료만큼 뺀다.
				taxi.custom = curCustom; // 손님을 태운다.
				
				map[taxi.x][taxi.y] = 0; // 맵에 손님을 지우고
				state[taxi.x][taxi.y] = null; // 상태맵에 손님을 지운다.
				return; // 
			}
		}
	}
   /* 배열 범위 유효성 체크 */
	private static boolean isValid(int nx, int ny) {
		if(nx>0 && ny>0 && nx<=N && ny<=N) return true;
		return false;
	}
}
