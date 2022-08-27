// 2022-08-27
// 게리멘더링

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static ArrayList<Integer>[] graph;
	static int [] value;
	static boolean[] isAreaA;
	static int[] aArea;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		graph = new ArrayList [N+1];
		value = new int [11];
		isAreaA = new boolean [11];
	
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			for(int j=0; j<M; j++) {
				int v = Integer.parseInt(st.nextToken());
				graph[i].add(v);
				graph[v].add(i);
			}
		}
		
		aArea = new int [N+1];
		subset(1);
		if(ans==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	private static void subset(int idx) {
		
		if(idx==N+1) {
			if(check()) {
				int aCnt=0, bCnt=0;
				for(int i=1; i<=N; i++) {
					if(isAreaA[i]) aCnt+=value[i];
					else bCnt+=value[i];
				}
				
				ans = Math.min(ans, Math.abs(aCnt-bCnt));
			}
			
			return;
		}
		
		isAreaA[idx] = true;
		subset(idx+1);
		isAreaA[idx] = false;
		subset(idx+1);
		
	}
	private static boolean check() {
		boolean[] visited = new boolean [N+1];
		
		int areaA = -1;
		for(int i=1; i<=N; i++) {
			if(isAreaA[i]) {
				areaA = i;
				break;
			}
		}
		
		int areaB = -1;
		for(int i=1; i<=N; i++) {
			if(!isAreaA[i]) {
				areaB = i;
				break;
			}
		}
		
		if(areaA==-1 || areaB==-1) return false;
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(areaA);
		visited[areaA] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=0; i< graph[now].size(); i++) {
				if(visited[graph[now].get(i)]) continue;
				if(!isAreaA[graph[now].get(i)]) continue;
				visited[graph[now].get(i)] = true;
				q.add(graph[now].get(i));
			}
		}
		
		q.add(areaB);
		visited[areaB] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=0; i< graph[now].size(); i++) {
				if(visited[graph[now].get(i)]) continue;
				if(isAreaA[graph[now].get(i)]) continue;
				visited[graph[now].get(i)] = true;
				q.add(graph[now].get(i));
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) return false;
		}
		
		return true;
	}
}
