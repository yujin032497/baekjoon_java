// 2022-09-17
// 색종이 만들기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int white = 0;
	static int blue = 0;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		map = new int [N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0,0,N); // 0,0에서 N만큼 사이즈 찾기 부터 시작
		System.out.println(white);
		System.out.println(blue);
		
	}
	private static void cut(int x, int y, int n) {
		int sum = 0;
		
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(map[i][j]==1) {
					sum+=1;
				}
			}
		}
		
		if(sum==n*n) { // 찾는 범위가 사이즈 크기만큼이면
			blue+=1; // 파란색1증가
		} else if (sum==0) {
			white+=1; // 더한 값이 0이면 흰색부분
		} else {
			
			int half = n/2; // 범위를 N/2사이즈만큼 줄인다.
			
      // 나눈크기만큼 4분면 
			cut(x, y, half); // 0,0부터
			cut(x, y+half, half); // 0,나눈범위시작부터
			cut(x+half, y, half); // 나눈범위시작부터, y
			cut(x+half, y+half, half); // 나눈범위시작부터, 나눈범위시작부터
		}
		
	}

}
