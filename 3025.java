// 2022-08-21
// 돌 던지기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static int C, R;
	static char[][] map;
	static Stack<Point>[] dp;
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		
		C = Integer.parseInt(split[0]);
		R = Integer.parseInt(split[1]);
		
		map = new char[C][R];
		dp = new Stack[R];
		
		for(int i=0; i<R; i++) {
			dp[i] = new Stack<>();
		}
		
		// 지도 그리기
		for(int i=0; i<C; i++) {
			String line = in.readLine();
			for(int j=0; j<R; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		int N = Integer.parseInt(in.readLine());
		
		for(int i=0; i<N; i++) {
			int r = Integer.parseInt(in.readLine());
			
			while(!dp[r-1].isEmpty() && map[dp[r-1].peek().x][dp[r-1].peek().y]=='O') {
				
				dp[r-1].pop();
			}
			
			if(dp[r-1].isEmpty()) {
				drop(0,r-1,r-1);
			}
			else {
				drop(dp[r-1].peek().x, dp[r-1].peek().y,r-1);
			}
		}
		
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	
	private static void drop(int x, int y, int r) { //x: 돌 탐색 시작 위치x y: 돌 탐색 시작 위치y, r: 초기 돌 던질 열 값
		
		while(x+1<C && map[x+1][y]!='X') {
			
			if(map[x+1][y] == 'O') {
				if(isBound(x+1,y-1) && map[x][y-1] == '.' && map[x+1][y-1]=='.') { //왼쪽, 왼쪽아래
					x++;
					y--;
				} else if(isBound(x+1,y+1) && map[x][y+1] == '.' && map[x+1][y+1]=='.') {//오른쪽, 오른쪽아래
					x++;
					y++;
				} else break;
			} else x++;
			
			dp[r].push(new Point(x,y));
		}
		
		map[x][y] = 'O';
		
	}
	private static boolean isBound(int x, int y) {
		
		if(x>=0 && y>=0 && x<C && y<R) return true;
		else return false;
	}
}

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
