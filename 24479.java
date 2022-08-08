// 2022-08-09
// 알고리즘 수업 - 깊이 우선 탐색 1

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int[] result = new int [100001];
	static int cnt = 0; //순서 카운트
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 정점 개수
		int M = Integer.parseInt(st.nextToken()); // 간선 개수
		int R = Integer.parseInt(st.nextToken()); // 시작 정점
		
		LinkedList<Integer>[] graph = new LinkedList[N+1]; // 그래프
		
		for(int i=1; i<=N; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph[v1].add(v2); // 양방향으로
			graph[v2].add(v1);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(graph[i]); // 각 정점에 연결된 정점을 오름차순
		}
		
		boolean[] visited = new boolean [N+1]; // 방문체크배열
		
		DFS(R, graph, visited); // DFS 탐색 시작!!
        
     /* 출력 */
		for(int i=1; i<=N; i++) {
			sb.append(result[i]+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
	
  // DFS (깊이우선탐색)
	public static void DFS(int R, LinkedList<Integer>[] graph, boolean[] visited) {
		
		Iterator<Integer> iter = graph[R].listIterator();
		
		visited[R]=true; // 시작정점은 무조건 방문
		result[R]= ++cnt; // 순서 입력
		
		while(iter.hasNext()) { // 방문한 정점에 인접한 정점이 있다면
			int w = iter.next(); // 하나씩 읽어들인다.
			if(!visited[w]) { // 아직 방문하지 않았다면
				DFS(w, graph, visited); // DFS 호출
			}
		}
	}

}
