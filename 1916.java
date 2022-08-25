// 2022-08-25
// 최소비용 구하기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	
	static int N, M,S,E;
	static ArrayList<Node>[] graph;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static boolean[] visited;
	static int[] distance;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		graph = new ArrayList[N+1];
		visited = new boolean [N+1];
		distance = new int [N+1];
		
		for(int i=1; i<=N; i++){
			graph[i] = new ArrayList<Node>();
		}
		for(int i=0; i<=N; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		String[] split;
		for(int i=0; i<M; i++) {
			split = in.readLine().split(" ");
			int v1 = Integer.parseInt(split[0]);
			int v2 = Integer.parseInt(split[1]);
			int w = Integer.parseInt(split[2]);
			
			graph[v1].add(new Node(v2,w));
		}
		
		split = in.readLine().split(" ");
		S = Integer.parseInt(split[0]); //출발점
		E = Integer.parseInt(split[1]); //도착점
		
		pq.offer(new Node(S,0));
		distance[S]=0;
		

		while(!pq.isEmpty()) {
			
			Node current = pq.poll();
			int c_v = current.vertex;
			if(visited[c_v]) continue;
			visited[c_v] = true;
			
			for(int i=0; i<graph[c_v].size(); i++) {
				Node tmp = graph[c_v].get(i);
				int next = tmp.vertex;
				int value = tmp.value;
				if(distance[next]> distance[c_v]+value) {
					distance[next] = distance[c_v]+value;
					pq.add(new Node(next, distance[next]));
				}
			}
			
		}
		
		System.out.println(distance[E]);
	}

}

class Node implements Comparable<Node> {

	int vertex;
	int value;
	
	public Node() {};
	public Node(int vertex, int value) {
		this.vertex = vertex;
		this.value = value;
	}
	
	@Override
	public int compareTo(Node o) {
		if(this.value>o.value) return 1;
		else return -1;
	}
	
}
