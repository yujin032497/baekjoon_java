// 2022-11-09
// 스타트와 링크

import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;
	static boolean[] visited;
	static int Min;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		map = new int [N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N+1];
		Min = Integer.MAX_VALUE;
		comb(1,0);
		System.out.println(Min);
	}
	private static void comb(int start, int cnt) {
		
		if(cnt==N/2) {
			Calc();
			return;
		}
		
		for(int i=start; i<=N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			comb(i+1, cnt+1);
			visited[i] = false;
		}
	}
	private static void Calc() {
		
		int team_start = 0;
		int team_link = 0;
		
		for(int i=1; i<=N-1; i++) {
			for(int j=i+1; j<=N; j++) {
				if(visited[i] && visited[j]) {
					team_start += map[i][j];
					team_start += map[j][i];
				} else if(!visited[i] && !visited[j]) {
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}
		
		int ans = Math.abs(team_start - team_link);
		
		if(ans==0) {
			System.out.println(ans);
			System.exit(0);
		}
		
		Min = Math.min(Min, ans);
	}
}
