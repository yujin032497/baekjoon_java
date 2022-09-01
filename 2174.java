// 2022-09-01
// 로봇 시뮬레이션

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Robot {
		int x;
		int y;
		int direct;
		
		public Robot(int x, int y, int direct) {
			this.x = x;
			this.y =y;
			this.direct = direct;
		}
	}
	
	static int A, B, N, M;
	static int [][] map;
	static ArrayList<Robot> robots;
	static String direction = "NESW";
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static int num, cycle;
	static char pip;
	static String ans;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new int [B+1][A+1];
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		robots = new ArrayList<>();
		ans="";

		// 초기 로봇 좌표
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int direct = direction.indexOf(st.nextToken());
			robots.add(new Robot(B-y+1,x,direct));
			map[B-y+1][x] = i+1;
		}
		
		/*System.out.println();
	
		for(int i=1; i<=B; i++) {
			for(int j=1; j<=A; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		*/
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			
			num = Integer.parseInt(st.nextToken()); //명령을 내릴 로봇
			pip =  st.nextToken().charAt(0); // 명령어 종류
			cycle = Integer.parseInt(st.nextToken()); //명령 반복횟수
			
			simulate();
			if(!ans.equals("")) break;
		}
		
		if(ans.equals("")) ans = "OK";
		System.out.println(ans);
	}

	private static void simulate() {
		
		int curX = robots.get(num-1).x;
		int curY = robots.get(num-1).y;
		int curD = robots.get(num-1).direct;
		
		for(int i=0; i<cycle; i++) {
			
			switch(pip) {
			case 'L':
				curD-=1;
				if(curD==-1) curD=3;
				break;
			case 'R':
				curD+=1;
				if(curD==4) curD=0;
				break;
			case 'F':
				curX += dx[curD];
				curY += dy[curD];
				break;
			}
			
			if(!isValid(curX,curY)) {
				ans = "Robot " + num + " crashes into the wall";
				return;
			}
			if(map[curX][curY]!=0 && map[curX][curY]!=num) {
				ans = "Robot " + num + " crashes into robot " + map[curX][curY];
				return;
			}

		}
		
		map[robots.get(num-1).x][robots.get(num-1).y] = 0;
		map[curX][curY] = num;
		robots.get(num-1).x = curX;
		robots.get(num-1).y = curY;
		robots.get(num-1).direct = curD;
		/*
		System.out.println();
		for(int i=1; i<=B; i++) {
			for(int j=1; j<=A; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("RobotX: " + robots.get(num-1).x + " RobotY: " + robots.get(num-1).y + " RobotDirection: " + direction.charAt(robots.get(num-1).direct));*/
		
	}

	private static boolean isValid(int curX, int curY) {
		if(curX>=1 && curY>=1 && curX<=B && curY<=A) return true;
		else return false;
	}
}
