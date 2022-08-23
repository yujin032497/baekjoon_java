// 2022-08-23
// ABCDE

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
	
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static int ans;
	static boolean status;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
	
		graph = new LinkedList [N];
		
		for(int i=0; i<N; i++) {
			graph[i] = new LinkedList<>();
		}
		
		
		
		// 그래프 그리기
		for(int i=0; i<M; i++) {
			split = in.readLine().split(" ");
			int v1 = Integer.parseInt(split[0]);
			int v2 = Integer.parseInt(split[1]);
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		
		for(int i=0; i<N; i++) {
			visited = new boolean [N];
			status = false;
			dfs(i, 1);
			
			if(status == true) break;
		}
		
		System.out.println(ans);
		
	}
	private static void dfs(int start, int depth) {
		
		visited[start] = true;
		if(depth == 5) {
			ans = 1;
			status = true;
			return;
		}
		
		Iterator<Integer>iter = graph[start].listIterator();
		
		while(iter.hasNext()) {
			int w = iter.next();
			if(!visited[w]) {
				dfs(w, depth+1);
			}
		}
		visited[start] = false;
		
	}
}
