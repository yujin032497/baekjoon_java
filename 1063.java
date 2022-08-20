// 2022-08-20
// 킹

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[][] map = new int [9][9];
	static String[] mode = {"R","L","B","T","RT","LT","RB","LB"};
	static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
	static int[] dy = {1,-1, 0, 0, 1, -1, 1, -1};
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] split = in.readLine().split(" ");
		
		int kingY = split[0].charAt(0)-64;
		int kingX = 9-(split[0].charAt(1)-'0');
		map[kingX][kingY] = 1;
		
		int dolY = split[1].charAt(0)-64;
		int dolX = 9-(split[1].charAt(1)-'0');
		map[dolX][dolY] = 2;
		
		int N = Integer.parseInt(split[2]);
		for(int i=0; i<N; i++) {
			String move = in.readLine();
			int idx = Arrays.asList(mode).indexOf(move);
			
			if(kingX+dx[idx]>=1 && kingY+dy[idx]>=1 && kingX+dx[idx]<9 && kingY+dy[idx]<9) {
				// 범위 안에 움직일 수 있다면
				if(map[kingX+dx[idx]][kingY+dy[idx]]==2) { //움직이려는 위치에 돌이 있으면
					
					if(dolX+dx[idx]>=1 && dolY+dy[idx]>=1 && dolX+dx[idx]<9 && dolY+dy[idx]<9) {
						
						map[kingX][kingY] = 0;
						map[dolX][dolY] = 0;
						map[kingX+dx[idx]][kingY+dy[idx]] = 1;
						map[dolX+dx[idx]][dolY+dy[idx]] = 2;
						dolX += dx[idx];
					 	dolY += dy[idx];
						
					} else {
						continue;
					}
				} else {
					map[kingX][kingY] = 0;
					map[kingX+dx[idx]][kingY+dy[idx]] = 1;
				}
			
				kingX +=dx[idx];
				kingY +=dy[idx];
			}
		}
		
		sb.append((char) (kingY+64)).append(9-kingX).append("\n");
		sb.append((char) (dolY+64)).append(9-dolX).append("\n");
		System.out.println(sb);
	}

}
