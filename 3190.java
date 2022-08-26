// 2022-08-26
// 뱀

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Direction> direct = new ArrayList<>();
	static int[] dx = {0, 1, 0, -1}; //우,하,왼,상
	static int[] dy = {1, 0, -1, 0};
	static Queue<int[]> snake = new LinkedList<>();
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(in.readLine()); //보드크기
		int K = Integer.parseInt(in.readLine()); //사과의 개수
		
		int[][] map = new int [N+1][N+1];
		
		// 지도에 사과 표시
		for(int i=1; i<=K; i++) {
			st = new StringTokenizer(in.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = 9; //사과표시
		}
		
		int L = Integer.parseInt(in.readLine()); // 뱀의 방향 변환 횟수
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			direct.add(new Direction(x,c));
		}
		
		int x = 1, y = 1;
		snake.offer(new int[] {x,y});
		map[x][y] = 2;
		int idx = 0, time = 0, direction = 0;
		
		while(true) {
				
			int nx = x+dx[idx];
			int ny = y+dy[idx];
			
			if(nx>=1 && ny>=1 && nx<=N && ny<=N && map[nx][ny] != 2) {
				if(map[nx][ny]==0) {
					map[nx][ny]=2;
					snake.offer(new int[] {nx,ny});
					
					int[] p = snake.poll();
					map[p[0]][p[1]] = 0;
					
				} else if (map[nx][ny]==9) {
					map[nx][ny]=2;
					snake.offer(new int[] {nx,ny});
				}
			} else {
				time+=1;
				break;
			}
			
			time+=1;
			if(direction<L && direct.get(direction).X == time) {
				char c = direct.get(direction).C; // 뱀이 전환할 방향
				
				if(c=='D') {
					idx = (idx+1)%4;
				}
				else if(c=='L') {
					idx = (idx-1)%4;
					if(idx<0) idx = 4+idx;
				}
				
				direction+=1;
			}
			
			x = nx;
			y = ny;
			
		}
		
		
		System.out.println(time);
	}

}
class Direction {
	int X;
	char C;
	
	public Direction() {};
	public Direction(int X, char C) {
		this.X = X;
		this.C = C;
	}
}
