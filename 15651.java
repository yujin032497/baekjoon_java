// 2022-08-12
// N과 M (4)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static boolean[] visited;
	static int[] numbers;
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		numbers = new int [N+1];
		
		DFS(0);
		
		System.out.print(sb);
	}

	private static void DFS(int index) {
		// TODO Auto-generated method stub
		if(index == M) {
			for(int i=0; i<M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<N+1; i++) {
			visited[i] = true;
			numbers[index] = i;
			DFS(index+1);
			visited[i] = false;
		}
	}

}
