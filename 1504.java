// 2022-08-25
// 특정한 최단경로

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {

	static int N,E;
	static ArrayList<Edge>[] graph;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	static boolean[] visited;
	static int[] distance;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList [N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[a].add(new Edge(b,w));
			graph[b].add(new Edge(a,w));
		}
		
		st = new StringTokenizer(in.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int res = 0, res2 = 0;
		
		// 출발->v1->v2->최종
		int value1=0, value2=0, value3=0;
		
		value1=dijkstara(1,v1);
		value2=dijkstara(v1,v2);
		value3=dijkstara(v2,N);
		
		if(value1!=Integer.MAX_VALUE && value2!=Integer.MAX_VALUE && value3!=Integer.MAX_VALUE) {
			res+=(value1+value2+value3);
		} else res = Integer.MAX_VALUE;
		
		// 출발->v2->최종
		value1=dijkstara(1, v2);
		value2=dijkstara(v2,v1);
		value3=dijkstara(v1,N);
		
		if(value1!=Integer.MAX_VALUE && value2!=Integer.MAX_VALUE && value3!=Integer.MAX_VALUE) {
			res2+=(value1+value2+value3);
		} else res2 = Integer.MAX_VALUE;
		
		if(res==Integer.MAX_VALUE && res2==Integer.MAX_VALUE) System.out.println(-1);
		else {
			if(res==Integer.MAX_VALUE) System.out.println(res2);
			else if(res2==Integer.MAX_VALUE) System.out.println(res);
			else System.out.println(Math.min(res, res2));
		}

	}
	
	private static int dijkstara(int start, int end) {
		visited = new boolean [N+1];
		distance = new int [N+1];
		
		for(int i=0; i<=N; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		pq.add(new Edge(start,0));
		distance[start]=0;
		
		while(!pq.isEmpty()) {
					
			Edge current = pq.poll();
			int c_v = current.vertex;
			if(visited[c_v]) continue;
			visited[c_v] = true;
			for(int i=0; i<graph[c_v].size(); i++) {
				Edge tmp = graph[c_v].get(i);
				int next = tmp.vertex;
				int value = tmp.value;
				
				if(distance[next] > distance[c_v] + value) {
					distance[next] = value + distance[c_v];
					pq.add(new Edge(next, distance[next]));
				}
			}
		}
		return distance[end];
	}
}
class Edge implements Comparable<Edge> {
	
	int vertex;
	int value;
	
	public Edge() {}
	public Edge(int vertex, int value) {
		this.vertex = vertex;
		this.value = value;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		if(this.value > o.value) return 1;
		else return -1;
	}
}
