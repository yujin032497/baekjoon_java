// 2022-09-06
// 연구소3

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Virus {
		int x;
		int y;
		
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N,M;
	static int [][] map;
	static ArrayList<Virus> viruses;
	static int emptyCnt;
	static int [] numbers;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static int ans = Integer.MAX_VALUE;
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][N];
		viruses = new ArrayList<Virus>();
		emptyCnt = 0; // 퍼트릴 칸 수
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					map[i][j] = -1; // 벽은 -1로 표시
				}
				else if(map[i][j] == 2) {
					viruses.add(new Virus(i,j));
					map[i][j] = -2; // 바이러스를 -2로 표시
				} else {
					emptyCnt+=1;
				}
			}
		}
		
		numbers = new int [M];
		comb(0,0);
		if(ans==Integer.MAX_VALUE) ans = -1; // 모든 빈칸에 퍼트리지 못했으면 -1
		else if(emptyCnt!=0) ans+=1; // 퍼트릴 빈칸이 있었으면 +1
                                // 다 퍼트렸을 경우는 빈칸이 없으므로 시간이 +1이 안됐기 때문
    // else ans; // 모든 빈칸에 퍼트릴 칸이 아예 없는 경우는 0초의 시간이 흘렀으나
                 // 모든 빈칸에 
		System.out.println(ans); 
		
	}
	private static void comb(int start, int count) {
		
		if(count==M) {
			Spread();
			return;
		}
		
		for(int i=start; i<viruses.size(); i++) {
			numbers[count]=i;
			comb(i+1, count+1);
		}
	}
	private static void Spread() {
		boolean[][] visited = new boolean[N][N];
		int[][] copyMap = new int [N][N];
		int time = 0;
		int cnt = emptyCnt;
		boolean isMove;
		
		// 바이러스를 새로운 조합으로 뽑았을 경우 맵 초기화
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		Queue<Virus> q = new ArrayDeque<>();
		
		// 선택한 바이러스를 큐에 넣기
		for(int i=0; i<numbers.length; i++) {
			q.add(viruses.get(numbers[i]));
			int x = viruses.get(numbers[i]).x;
			int y = viruses.get(numbers[i]).y;
			visited[x][y]=true;
			copyMap[x][y] = 0;	
		}

		while(!q.isEmpty()) {
			
			int len = q.size();
			isMove = false;
			
			for(int l=0; l<len; l++) {
				Virus v = q.poll();
				
				int curX = v.x;
				int curY = v.y;
				
				// 4방탐색
				for(int i=0; i<4; i++) {
					int nx = curX + dx[i];
					int ny = curY + dy[i];
					
					if(isValid(nx, ny) && !visited[nx][ny]) {
						if(copyMap[nx][ny]==-2 || copyMap[nx][ny]==0) {
							if(copyMap[nx][ny]==0) {
								cnt-=1;
								copyMap[nx][ny] = copyMap[curX][curY]+1;
								
							} else if(copyMap[nx][ny]==-2) {
								copyMap[nx][ny] = 0;
							}
							q.add(new Virus(nx,ny));
							isMove = true; // 비활성화 바이러스를 활성화 시키거나 퍼트리면 움직임.
							
						}
						visited[nx][ny] = true;
						
					}
					
				}

			}
			
			if(cnt!=0 && isMove) time+=1; // 한번이라도 움직였으면 시간이 흐름.
                                    // 단, 모든 칸에 바이러스를 
			
		}
		
		if(cnt==0) {
			
			if(ans>time) {
				ans = time;
				
				/*System.out.println();
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						System.out.print(copyMap[i][j]+ " ");
					}
					System.out.println();
				}*/
			}
		}
		
	}
	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<N && ny<N) return true;
		else return false;
	} 

}
