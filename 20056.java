// 2022-10-17
// 마법사 상어와 파이어볼

import java.io.*;
import java.util.*;

public class Main {
	static class Fireball {
		int r;
		int c;
		int m;
		ArrayList<Integer> d = new ArrayList<>();
		int s;
		int cnt;
		
		public Fireball(int r, int c, int m, int d, int s, int cnt) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.d.add(d);
			this.s = s;
			this.cnt = cnt;
		}
	}
	static int N, M, K;
	static Fireball [][] map;
	static int[] dx = {-1,-1,0,1,1,1,0,-1}; // 8방향
	static int[] dy = {0,1,1,1,0,-1,-1,-1}; 
	static ArrayList<Fireball> fireballs = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new Fireball [N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			fireballs.add(new Fireball(r,c,m,d,s,1));
		}
		
		for(int i=0; i<K; i++) {
			Simulate();	
		}
		
		int ans = 0;
		for(int i=0; i<fireballs.size(); i++) {
			ans+=fireballs.get(i).m;
		}
		
		System.out.println(ans);
		
	}
	private static void Simulate() {
		
		// 1. 모든 파이어볼이 자신의 방향 d로 속력 s만큼 이동
		for(int i=0; i<fireballs.size(); i++) {
			
			int r = fireballs.get(i).r; // 좌표 x
			int c = fireballs.get(i).c; // 좌표 y
			int s = fireballs.get(i).s; // 속력
			int d = fireballs.get(i).d.get(0); // 방향
			
			s %= N;
			
			for(int j=0; j<s; j++) {
				
				int nr = r + dx[d];
				int nc = c + dy[d];
				
				if(nr==0) nr=N;
				else if(nr==N+1) nr = 1;
				
				if(nc==0) nc=N;
				else if(nc==N+1) nc=1;
				
				r = nr;
				c = nc;
				
			}
			
			fireballs.get(i).r = r; // 좌표 재설정
			fireballs.get(i).c = c;
		}
		
		// 2-1 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
		for(int i=0; i<fireballs.size(); i++) {
			int r = fireballs.get(i).r;
			int c = fireballs.get(i).c;
			int m = fireballs.get(i).m;
			int d = fireballs.get(i).d.get(0);
			int s = fireballs.get(i).s;
			
			if(map[r][c]==null) map[r][c] = new Fireball(r,c,m,d,s,1); // 맵에 파이어볼이 하나도 없다면 새로 생성
			else { // 맵에 파이어볼이 있다면 합친다.
				map[r][c].m+=m;
				map[r][c].d.add(d);
				map[r][c].s+=s;
				++map[r][c].cnt;
			}
		}
		
		fireballs.clear();
		
		// 2-2. 파이어볼은 4개의 파이어볼로 나누어진다.
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] == null) continue;
				if(map[i][j].cnt < 2) fireballs.add(map[i][j]);
				else {
					int m = map[i][j].m/5;
					if(m==0) {
						map[i][j] = null; // 질량이 0이면 파이어볼이 소멸된다.
						continue;
					}
					int s = map[i][j].s/map[i][j].cnt;
					
					int n = map[i][j].d.get(0)%2;
					boolean isAll = true;
					for(int k=1; k<map[i][j].d.size(); k++) {
						if(n!=map[i][j].d.get(k)%2) {
							isAll = false;
							break;
						}
					}
					
					if(isAll) { // 모두 홀수이거나 모두 짝수이면
						int d = 0;
						for(int k=0; k<4; k++) {
							fireballs.add(new Fireball(i,j,m,d,s,1));
							d+=2;
						}
					} else {
						int d=1;
						for(int k=0; k<4; k++) {
							fireballs.add(new Fireball(i,j,m,d,s,1));
							d+=2;
						}
					}
				}
				map[i][j] = null;
			}
		}
	}
}
