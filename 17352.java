// 2022-09-06
// 여러분의 다리가 되어드리겠습니다!

//** 서로소 집합 문제**

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] graph;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		
		graph = new int [N+1];
		
		// 초기화
		for(int i=1; i<=N; i++) {
			graph[i] = i;
		}
		
		for(int i=0; i<N-2; i++) {
			st = new StringTokenizer(in.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			union(A,B);
		}
		
		int ans = 0;
		for(int i=2; i<=N; i++) {
			if(find(1)!=find(i)) { //1번노드의 부모와 i번 노드의 부모를 비교해서 부모가 다르면 출력(연결해야함)
				ans = i;
				break;
			}
		}
		System.out.println(1+" "+ans);
	}
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a!=b) {
			if(a<b) graph[b] = a;
			else graph[a] = b;
		}
		
	}
	private static int find(int n) {
		if(n==graph[n]) return n;
		else return graph[n] = find(graph[n]);
	}

}
