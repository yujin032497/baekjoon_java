// 2022-08-21
// 로봇 청소기

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N, M;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int cnt;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		split = in.readLine().split(" ");
		int robotX = Integer.parseInt(split[0]);
		int robotY = Integer.parseInt(split[1]);
		int robotM = Integer.parseInt(split[2]);
		
		map = new int [N][M];
		
		for(int i=0; i<N; i++) {
			split = in.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		cnt = 1;
		clean(robotX, robotY, robotM);
		System.out.println(cnt);
	}
	private static void clean(int robotX, int robotY, int robotM) {
	
		map[robotX][robotY] = 9;
		
		for(int i=0; i<4; i++) {
			
			robotM = (robotM+3)%4;
			int nx = robotX+dx[robotM];
			int ny = robotY+dy[robotM];
			
			if(nx>=0 && ny >=0 && nx<N && ny<M && map[nx][ny]==0) {
				cnt++;
				
				clean(nx, ny, robotM);
				return;
			
			}
		}
		
		int back = (robotM+2)%4;
		int bx = robotX + dx[back];
		int by = robotY + dy[back];
		
		if(bx>=0 && by >=0 && bx<N && by<M && map[bx][by]!=1) {
			clean(bx, by, robotM);
		}
	}
}
