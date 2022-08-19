// 2022-08-20
// 정원 (Easy)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = in.readLine().split(" ");
		
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		
		int[][] map = new int [N+1][M+1];
		
		split = in.readLine().split(" ");
		for(int i=1; i<=N; i++) {
			map[i][0] = Integer.parseInt(split[i-1]);
		}
		
		split = in.readLine().split(" ");
		for(int i=1; i<=M; i++) {
			map[0][i] = Integer.parseInt(split[i-1]);
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(map[i][j-1]==map[i-1][j]) map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		
		System.out.println(map[N][M]);
	}

}
