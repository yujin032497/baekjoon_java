// 2022-08-12
// N과 M (2)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static boolean[] visited; // 방문 체크 배열
	static int[] arr; // 방문 노드 저장 배열
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		
		visited = new boolean [N];
		arr = new int [M];
		
		dfs(N, M, 0, 0); // DFS 메서드 호출
	}

  /*DFS 메서드*/
  // 중복이 안되므로 조합으로 
	private static void dfs(int N, int M, int depth, int start) {
		
		if(depth == M) {
			for(int val : arr) {
				
				System.out.print(val + " ");
			}
			
			System.out.println();
				
			return;
		}
		
		for(int i=start; i<N; i++) {
				
            arr[depth] = i+1;

            dfs(N, M, depth+1, i+1);

		}
	}

}
