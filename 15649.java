import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static boolean[] visited; // 방문 체크 배열
	static int[] arr; // 깊이에 따른 노드 저장 배열
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		
		
		visited = new boolean [N];
		arr = new int[M];
		
		dfs(N, M, 0); DFS 호출
		
	}

  /* DFS 메서드 */
	private static void dfs(int N, int M, int depth) {
		
		if(depth == M) { 깊이와 M이 같으면
			for (int val : arr) { // 출력
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) { // 방문하지 않은 노드라면
				
				visited[i] = true; // 방문하고
				arr[depth] = i+1; // 깊이에 따른 i+1 저장
				dfs(N, M, depth+1); 다시 DFS 호출
				
				
				visited[i] = false;
			}
		}
		
		return;
		
		
	}

}
