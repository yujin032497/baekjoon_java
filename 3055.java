// 2022-08-24
// 탈출

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int R,C;
	static char[][] map;
	static int[] dx = {-1, 1, 0, 0}; // 위 아래 오른쪽 왼쪽
	static int[] dy = {0, 0, -1, 1};
	static Queue<Point> water;
	static Queue<Point> go;
	static int time, ans;
	static boolean status = false;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		R = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);
		
		map = new char [R][C];
		water = new LinkedList<>();
		go = new LinkedList<>();
		
		//지도 그리기
		for(int i=0; i<R; i++) {
			String line = in.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == '*') water.add(new Point(i,j));
				else if(map[i][j] == 'S') go.add(new Point(i,j));
			}
		}
		
		time = 0;
		ans = Integer.MAX_VALUE;
		run();
		
		if(status) System.out.println(ans);
		else System.out.println("KAKTUS");
		
	}
	private static void run() {
		// TODO Auto-generated method stub
		while(!go.isEmpty()) { // 고슴도치 좌표가 큐가 끝날때까지
      
      /*물뿌리기*/
			int len = water.size();
			for(int k=0; k<len; k++) { // 1 사이클
				Point p = water.poll(); 
				
				for(int i=0; i<4; i++) {
					int nx = p.x+dx[i];
					int ny = p.y+dy[i];
					if(isInBound(nx,ny) && map[nx][ny] != 'X' && map[nx][ny] != 'D' && map[nx][ny] != '*') {
						map[nx][ny] = '*';
						water.add(new Point(nx,ny));
					}
				}
			}
			
			// 물 다 뿌렸으면
			/*고슴도치 이동*/
			len = go.size();
			for(int j = 0; j<len; j++) {
				Point p = go.poll();
				for(int i=0; i<4; i++) {
					int nx = p.x+dx[i];
					int ny = p.y+dy[i];
					if (isInBound(nx,ny)) {
						if(map[nx][ny]=='D') {
							ans = Math.min(ans, time+1);
							status = true;
							return;
						} else if(map[nx][ny] == '.') {
							map[nx][ny]='S';
							go.add(new Point(nx,ny));
							
						}
					}
				}
				
			}
			time++;
			run();
		}
	}
		
	private static boolean isInBound(int nx, int ny) {
		if (nx>=0 && ny>=0 && nx < R && ny < C) return true;
		else return false;
	}
}
class Point {
	
	int x;
	int y;
	
	public Point (int x, int y) {
		
		this.x = x;
		this.y = y;
	}
}
