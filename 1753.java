// 2022-08-25
// 최단경로

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

	static int V,E,K;
	static ArrayList<Edge>[] graph;
	static PriorityQueue<Edge> q = new PriorityQueue<Edge>();
	static boolean[] visited;
	static int[] distance;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = in.readLine().split(" ");
		V = Integer.parseInt(split[0]); // 정점수
		E = Integer.parseInt(split[1]); // 간선수
		K = Integer.parseInt(in.readLine());// 시작정점
		
		visited = new boolean [V+1];
		distance = new int [V+1];
		graph = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		for(int i=0; i<V+1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<E; i++) {
			split = in.readLine().split(" ");
			int v1 = Integer.parseInt(split[0]);
			int v2 = Integer.parseInt(split[1]);
			int w = Integer.parseInt(split[2]);
			graph[v1].add(new Edge(v2, w));
		}
		
		q.add(new Edge(K,0)); // 시작정점 K점 설정
		distance[K] = 0;
		
		while(!q.isEmpty()) {
			Edge current = q.poll();
			int currentVertex = current.vertex;
			if(visited[currentVertex]) continue;
			visited[currentVertex] = true;
			
			for(int i=0; i<graph[currentVertex].size(); i++) {
				Edge tmp = graph[currentVertex].get(i);
				int next = tmp.vertex;
				int value = tmp.value;
				if(distance[next] > distance[currentVertex]+value) { // 최소거리 업데이트
					distance[next] = value + distance[currentVertex];
					q.add(new Edge(next, distance[next]));
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(visited[i]) {
				System.out.println(distance[i]);
			} else {
				System.out.println("INF");
			}
		}
	}
}
class Edge implements Comparable<Edge> {
	int vertex; // 정점
	int value; // 가중치
	
	public Edge() {};
	public Edge(int vertex, int value) {
		this.vertex = vertex;
		this.value = value;
	}
	@Override
	public int compareTo(Edge o) {
		if(this.value > o.value) return 1;
		else return -1;
	}
	
}
