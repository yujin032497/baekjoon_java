// 2022-11-01
// 벽 부수고 이동하기 4

import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static char[][] map;
	static int[][] group;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static HashMap<Integer, Integer> hm = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M]; // 맵
		group = new int [N][M]; // 그룹핑
		int idx = 1; // 그룹번호
		
		// 맵 그리기
		for(int i=0; i<N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == '0' && group[i][j]==0) {
					hm.put(idx, Bfs(i,j,idx)); // 그룹찾아서 한 그룹으로 묶어버리기
											  // 그룹당 몇개인지 넣어준다.
					idx++; // 그룹번호 증가
				}
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(mapCount(i,j));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int mapCount(int x, int y) {
		int sum = 1; // 자기자신을 포함한다.
		HashSet<Integer> hs = new HashSet<>(); // 같은 그룹의 중복을 없애기 위해
		
		if(map[x][y] == '0') return 0; // 빈칸이면 0
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isValid(nx,ny)) {
				if(map[nx][ny] == 0) continue; // 그룹핑이 되어있지 않으면 넘긴다.
				if(map[nx][ny] == '0') { // 벽이 아니면 
					hs.add(group[nx][ny]); // 그룹에 있는 값을 넣어준다.
				}
			}
		}
		
		for(int ind : hs) {
			sum += hm.get(ind); // 그룹에 있는 값을 가져와서 더해주면 그 값이 통과할 수 있는 개수
		}
		
		return sum%10; // 10을 나눈 나머지 출력
	}

	private static Integer Bfs(int x, int y, int idx) {
		int count = 1;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {x,y});
		group[x][y] = idx;
		
		while(!q.isEmpty()) {
			
			int[] p = q.poll();
			
			int curX = p[0];
			int curY = p[1];
			
			for(int i=0; i<4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(isValid(nx,ny) && map[nx][ny]=='0' && group[nx][ny] == 0) { // 지나갈 수 있는 빈칸이고 아직 그룹핑이 안되어있는 칸이면
					q.offer(new int[] {nx,ny});
					group[nx][ny] = idx;
					count++;
				}
			}
		}
		return count;
	}

	private static boolean isValid(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<N && ny<M) return true;
		return false;
	}
}
