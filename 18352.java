// 2022-08-35
// 특정 거리의 도시 찾기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static ArrayList<Integer>[] graph;
	static int[] visited;
	static List<Integer> answer;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		int K = Integer.parseInt(split[2]);
		int X = Integer.parseInt(split[3]);
		
		graph = new ArrayList[N+1];
		answer = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			split = in.readLine().split(" ");
			int v1 = Integer.parseInt(split[0]);
			int v2 = Integer.parseInt(split[1]);
			
			graph[v1].add(v2);
		}
		
		visited = new int [N+1];
		for(int i=0; i<=N; i++) {
			visited[i] = -1;
		}
		
		BFS(X);
		
		for(int i=0; i<=N; i++) {
			if(visited[i]==K) {
				answer.add(i);
			}
		}
		
		if(answer.isEmpty()) System.out.println(-1);
		else {
			Collections.sort(answer);
			for(int tmp: answer) {
				System.out.println(tmp);
			}
		}
	}
	private static void BFS(int Node) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(Node);
		visited[Node]++; // 출발점은 0
		
		while(!q.isEmpty()) {
			int nowNode = q.poll();
			for(int i : graph[nowNode]) {
				if(visited[i] == -1) {
					visited[i] = visited[nowNode]+1
							;
					q.add(i);
				}
			}
		}
	}

}
