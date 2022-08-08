// 2022-08-08
// DFS와 BFS

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 수
		int M = Integer.parseInt(st.nextToken()); // 간선의 수
		int V = Integer.parseInt(st.nextToken()); // 시작정점
		
		LinkedList<Integer>[] graph = new LinkedList[N+1];
		
		for(int i=0; i<=N; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			// 양방향
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(graph[i]);
		}
		
		boolean[] visitedDFS = new boolean[N+1]; // DFS 방문체크
		
		DFS(V, graph,visitedDFS);
		sb.deleteCharAt(sb.length()-1);
		sb.append("\n");
		
		boolean[] visitedBFS = new boolean[N+1]; // BFS 방문체크
		
		BFS(V,graph,visitedBFS);
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}
	
	
	//DFS(재귀활용)
	public static void DFS(int V, LinkedList<Integer>[]graph, boolean[] visited) {
		
		visited[V] = true;
		sb.append(V+" ");
		
		Iterator<Integer> iter = graph[V].listIterator();
		
		while(iter.hasNext()) {
			int w = iter.next();
			if(!visited[w]) {
				DFS(w, graph, visited);
			}
		}
	}
	
	//BFS(큐 활용)
	public static void BFS(int V, LinkedList<Integer>[] graph, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		visited[V] = true;
		queue.add(V);
		
		while(!queue.isEmpty()) {
			V = queue.poll();
			sb.append(V+" ");
			
			Iterator<Integer> iter = graph[V].listIterator();
			
			while(iter.hasNext()) {
				int w = iter.next();
				if(!visited[w]) {
					visited[w] = true;
					queue.add(w);
				}
			}
		}
		
	}

}
