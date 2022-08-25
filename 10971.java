// 2022-08-25
// 외판원 순회2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = 1000000 * 10 + 1;
	static int N;
	static int[][] W;
	static int[][] D;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		W = new int [10][10]; // 도시가 10개까지 한정
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		D = new int [10][1<<10];
		for(int i=0; i<N; i++) {
			for(int j=0; j<1<<N; j++) {
				D[i][j] = INF;
			}
		}
		
		System.out.println(tsp(0,1));
	}
	private static int tsp(int c, int v) {
		
		if(v==(1<<N) -1) {
			return W[c][0] == 0 ? INF : W[c][0];
		}
		
		if(D[c][v] != INF) {
			return D[c][v];
		}
		for(int i=0; i<N; i++) {
			if((v & (1 << i)) == 0 && W[c][i] != 0) {
				D[c][v] = Math.min(D[c][v], tsp(i, (v | (1 << i))) + W[c][i] );
			}
		}
		
		return D[c][v];
		
	}

}
