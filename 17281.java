// 2022-08-27
// ⚾

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] board;
	static boolean visited[] = new boolean [10];
	static int[] man = new int [10];
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		board = new int [N+1][10];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=1; j<=9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		man[4] = 1;
		visited[4] = true;
		
		perm(2);
		System.out.println(ans);
		
	}
	private static void perm(int num) {
		
		if(num==10) {
			play();
			return;
		}

		for(int i=1; i<=9; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			man[i] = num;
			perm(num+1);
			visited[i] = false;
		}
	}
	
	private static void play() {
		int score = 0;
		int startPlayer = 1;
		boolean[] base;
		
		for(int i=1; i<=N; i++) {
			int outCnt = 0;
			base = new boolean [4];
			
			outer:
			while(true) {
				for(int j=startPlayer; j<=9; j++) {
					int hitter = board[i][man[j]];
					
					switch(hitter) {
					case 0:
						outCnt+=1;
						break;
					case 1:
						for(int k=3; k>=1; k--) {
							if(base[k]) {
								if(k==3) {
									score+=1;
									base[k] = false;
									continue;
								}
								base[k] = false;
								base[k+1] = true;
							}
							
						}
						base[1] = true;
						break;
					case 2:
						for(int k=3; k>=1; k--) {
							if(base[k]) {
								if(k==3||k==2) {
									score+=1;
									base[k] = false;
									continue;
								}
								base[k] = false;
								base[k+2] = true;
							}
						}
						base[2] = true;
						break;
 					case 3:
						for(int k=3; k>=1; k--) {
							if(base[k]) {
								score+=1;
								base[k] = false;
							}
						}
						base[3] = true;
						break;
					case 4:
						for(int k=3; k>=1; k--) {
							if(base[k]) {
								score+=1;
								base[k] = false;
							}
						}
						score+=1;
						break;
					}
					
					if(outCnt==3) {
						startPlayer = j+1;
						if(startPlayer==10) startPlayer = 1;
						break outer;
					}
				}
				startPlayer = 1;
			}
		}
		
		ans = Math.max(ans, score);
	}
}
