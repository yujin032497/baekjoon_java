// 2022-10-05
// 낚시왕

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Shark {
		
		int r; //상어 세로 위치
		int c; //상어 가로 위치
		int s; //상어 속력
		int d; //상어이동방향 (1: 위, 2: 아래 3: 오른쪽,  4:왼쪽)
		int z; //크기
		
		public Shark() {}
		
		public Shark(int r, int c, int s, int d, int z) {
			
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	static class Fisher {
		int x;
		int y;
		int sum;
		
		public Fisher(int x, int y) {
			
			this.x = x;
			this.y = y;
		}
		
		
	}
	static int R,C,M;
	static Shark [][] map;
	static Fisher fisher;
	static int [] dx = {0,-1,1,0,0}; // 상하우좌
	static int [] dy = {0,0,0,1,-1};
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark [R+1][C+1];
		
		// 상어정보입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			map[r][c] = new Shark(r,c,s,d,z);
		}
		
		fisher = new Fisher(0,0);
		for(int i=0; i<C; i++) {
			simulate();
		}
		
		System.out.println(fisher.sum);
	}

	private static void simulate() {
		
		//1. 낚시왕이 오른쪽으로 한칸 이동한다.
		fisher.y +=1;
		
		//2. 낚시왕이 있는 열에 있는 상어중에 땅과 제일 가까운 상어를 잡는다.
		for(int i=1; i<=R; i++) {
			if(map[i][fisher.y]!=null) { // 상어가 있다면
				fisher.sum+=map[i][fisher.y].z; //낚시왕이 상어를 잡는다.
				map[i][fisher.y] = null; 
				break;
			}
		}
		
		Queue<Shark> q = new LinkedList<>();
		//3. 상어가 이동한다.
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				if(map[i][j]!=null) {
					q.add(map[i][j]); //맵에 있는 상어담기
				}
			}
		}
		
		map = new Shark[R+1][C+1]; //지도 다시 그리기

		//3. 상어 움직이기
		while(!q.isEmpty()) {
			Shark shark = q.poll();
			
			int s = shark.s;
			
			for(int i=0; i<s; i++) {
				int d = shark.d;
				int nr = shark.r + dx[d];
				int nc = shark.c + dy[d];
				
				if(!isValid(nr,nc)) { // 상어가 벽에 부딪히면
					nr -= dx[d];
					nc -= dy[d];
					
					//방향을 전환해준다.
					if(d==1) d=2; 
					else if(d==2) d=1;
					else if(d==3) d=4;
					else if(d==4) d=3;
					
					nr += dx[d];
					nc += dy[d];
				}
				
				shark.r = nr;
				shark.c = nc;
				shark.d = d;
			}
			
			// 상어 다시 배치하기
			if(map[shark.r][shark.c]==null) { //맵에 상어가 없으면
				map[shark.r][shark.c] = shark; // 상어배치
			} else { // 상어가 있으면
				if(map[shark.r][shark.c].z < shark.z) { // 맵에 있는 상어보다 크기가 크다면
					map[shark.r][shark.c] = shark; // 기존에 있는 상어 잡아먹기(맵에서 삭제)
				}
			}

		}
		/*for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				if(map[i][j]!=null) {
					Shark shark = map[i][j];
					System.out.println("r: " + shark.r + " c: " + shark.c + " s: " + shark.s + " d: " + shark.d + " z: " +shark.z );
				}
			}
			System.out.println("낚시왕이 잡은 크기: "+fisher.sum);
		}*/
		
	}

	private static boolean isValid(int nr, int nc) {
		if(nr>=1 && nc>=1 && nr<=R && nc<=C) return true;
		return false;
	}
}
