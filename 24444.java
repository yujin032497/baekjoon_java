// 2022-08-12
// 알고리즘 수업 - 너비 우선 탐색 1

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static Queue<Integer> q = new LinkedList<>(); // 큐
	static int[] result; // 결과값
	static int cnt = 0; // 순서카운터
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 정점수
		int M = Integer.parseInt(st.nextToken()); // 간선수
		int R = Integer.parseInt(st.nextToken()); // 시작정점
		
		LinkedList<Integer>[] graph = new LinkedList[N+1]; // 그래프
		boolean[] visited = new boolean[N+1]; // 방문 체크 배열
		result = new int [N+1];
		
    /*초기화*/
		for(int i=1; i<=N; i++) {
			graph[i] = new LinkedList<>();
		}
		
    /*그래프그리기*/
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		
    /*각 연결된 정점 오름차순*/
		for(int i=1; i<=N; i++) {
			Collections.sort(graph[i]);
		}
		
		BFS(R, graph, visited); // BFS 탐색 시작
    
    /*결과값 출력*/
		for(int i=1; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}

  
  /*BFS 메서드*/
	private static void BFS(int R, LinkedList<Integer>[] graph, boolean[] visited) {
		
		visited[R] = true; // 방문 정점 체크
		result[R] = ++cnt; // 정점 순서 카운팅
		
		q.addAll(graph[R]); // 방문한 정점과 연결된 정점 큐에 삽입
		
		while(!q.isEmpty()) { // 큐가 비어질때까지 반복
			
			int w = q.poll(); // 정점 하나를 꺼낸다.
			
			if(!visited[w]) { // 정점을 방문하지 않았다면
				
				BFS(w, graph, visited); // 해당 정점에 대한 BFS 탐색 호출
			}
			
		}
		
	}

}
