// 2022-08-13
// N-Queen

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[][] board;
	static boolean[] visited;
	static int count = 0;
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		board = new int [N+1][N+1];
		visited = new boolean [N+1];
		
		perm(1);
		System.out.print(count);
	}
	private static void perm(int index) {
		
		if(N==index-1) {
			count++;
			return;
		}
		
		for(int i=1; i<N+1; i++) {
			
			if(visited[index]) continue;
			if(!setting(index, i)) continue;
			visited[index] = true;
			perm(index+1);
			visited[index] = false;
			clear(index,i);
		}
	}
	private static void clear(int x, int y) {
		int i = 0;
		// 1로 표시한거 해제
			for(i=1; i<N+1; i++) {
				if(board[x][i]>0) board[x][i]-=1;
			}
			
			for(i=1; i<N+1; i++) {
				if(board[i][y]>0) board[i][y]-=1;
			}
			
			for(i=1; i<N+1; i++) {
				if(x+i>N | y+i>N) break;
				if(board[x+i][y+i]>0) board[x+i][y+i]-=1;
			}
			
			for(i=1; i<N+1; i++) {
				if(x-i<1 | y-i<1) break;
				if(board[x-i][y-i]>0) board[x-i][y-i]-=1;
			}
			
			for(i=1; i<N+1; i++) {
				if(x-i<1 | y+i>N) break;
				board[x-i][y+i]-=1;
			}
			
			for(i=1; i<N+1; i++) {
				if(x+i>N | y-i<1) break;
				board[x+i][y-i]-=1;
			}
		
	}
	private static boolean setting(int x, int y) {
		
		int i = 0;
		// 겹치는 칸이 있는지 체킹
		if(board[x][y]>0) return false;
		
		// 겹치지 않기 위해 1로 표시
		for(i=1; i<N+1; i++) {
			board[x][i]+=1;
		}
		
		for(i=1; i<N+1; i++) {
			board[i][y]+=1;
		}
		
		for(i=1; i<N+1; i++) {
			if(x+i>N | y+i>N) break;
			board[x+i][y+i]+=1;
		}
		
		for(i=1; i<N+1; i++) {
			if(x-i<1 | y-i<1) break;
			board[x-i][y-i]+=1;
		}
		
		for(i=1; i<N+1; i++) {
			if(x-i<1 | y+i>N) break;
			board[x-i][y+i]+=1;
		}
		
		for(i=1; i<N+1; i++) {
			if(x+i>N | y-i<1) break;
			board[x+i][y-i]+=1;
		}
		return true;
	}
}
