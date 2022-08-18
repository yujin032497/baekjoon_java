// 2022-08-18
// 바이러스

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
	
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		LinkedList<Integer>[] computer = new LinkedList[N+1];
		boolean[] visited = new boolean [N+1];
		for(int i=1; i<=N; i++) {
			computer[i] = new LinkedList<>();
		}
		
		for(int i=0; i<M; i++) {
			String[] split = in.readLine().split(" ");
			int v1 = Integer.parseInt(split[0]);
			int v2 = Integer.parseInt(split[1]);
			
			computer[v1].add(v2);
			computer[v2].add(v1);
		}
		
		dfs(computer, 1, visited);
		System.out.println(cnt-1);
	}

	private static void dfs(LinkedList<Integer>[] computer, int i, boolean[] visited) {
		
		visited[i] = true;
		cnt++;
		
		Iterator<Integer> iter = computer[i].listIterator();
		
		while(iter.hasNext()) {
			int w = iter.next();
			if(!visited[w]) {
				dfs(computer,w,visited);
			}
		}
		
	}

}
