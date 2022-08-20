// 2022-08-20
// 나이트 투어

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N = 6;
	static int M = 6;
	static int[] dx = {-2,-1,1,2,2,1,-1,-2};
	static int[] dy = {1,2,2,1,-1,-2,-2,-1};
	static boolean[][] map;
	static String ans;
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new boolean [N+1][M+1];
		ans = "";
		int startX = 0, endX = 0, startY = 0, endY = 0;
		int curX = 0, preX = 0, curY = 0, preY = 0;
		
		for(int i=0; i<36; i++) {
			String line = in.readLine();
			
			if(i>0) {
				preX = curX;
				preY = curY;
			}
			
			curY = line.charAt(0)-64;
			curX = Integer.parseInt(Character.toString(line.charAt(1)));
			
			if(i>0) {
				if(!check(preX, preY, curX, curY)) break;
			}
			
			if(i==0) {
				startX = curX;
				startY = curY;
				map[curX][curY] = true;
			} else if(i==35) {
				endX = curX;
				endY = curY;
			} 
			
		}
		
		if(startX>0 && endX>0 && startY>0 && endY>0) {
			for(int i=0; i<8; i++) {
				if(endX+dx[i] == startX & endY+dy[i]==startY) {
					ans = "Valid";
					break;
				} else {
					ans = "Invalid";
				}
			}
		}
		
		System.out.println(ans);
	}

	private static boolean check(int preX, int preY, int curX, int curY) {
		// TODO Auto-generated method stub
	
		for(int j=0; j<8; j++) {
			if(preX+dx[j]==curX & preY+dy[j]==curY) {
				if(map[curX][curY]) {
					ans = "Invalid";
					return false;
				} else {
					map[curX][curY] = true;
					ans = "Valid";
					return true;
				}
			} else {
				ans = "Invalid";
			}
		}
		
		if(ans.equals("Invalid")) return false;
		else return true;
		
	}

}
