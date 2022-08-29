// 2022-08-29
// 단지번호붙이기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int homeNum = 2;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cnt;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		visited = new boolean [N][N];
		
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			for(int j=0; j<N; j++) {
				
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					cnt = 0;
					DFS(i,j);
					list.add(cnt);
					homeNum+=1;
				}
			}
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	private static void DFS(int x, int y) {
		
		int curX = x;
		int curY = y;
		
		if(visited[curX][curY]) return;
		visited[curX][curY] = true;
		map[curX][curY] = homeNum;
		cnt+=1;
		
		for(int i=0; i<4; i++) {
			
			int nx = curX+dx[i];
			int ny = curY+dy[i];
			
			if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
			if(map[nx][ny]==0) continue;
			
			DFS(nx, ny);
			
		}
		
	}

}
