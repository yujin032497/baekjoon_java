// 2022-08-04
// 숨바꼭질

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	public static int BFS(int N, int K) {
		
		Queue<Integer> q = new LinkedList<>(); //DFS:재귀, 스택 BFS:큐, 링크드리스트
		int[] visited = new int [100001]; //방문배열: 범위가 1000000이므로 +1만큼 생성
		
		q.offer(N); //시작점을 큐에 넣는다.
		visited[N] = 1; //시작점에 1을 넣는다.(1초)
		
		while(!q.isEmpty()) {
			int nodeIdx = q.poll(); //큐는 FILO(Fist In Last Out)
			
			
			for(int i=0; i<3; i++) { //X+1, X-1, X*2일때
				int next = 0;
				
				if(i==0) next = nodeIdx+1; //X+1
				else if(i==1) next = nodeIdx-1; //X-1
				else next = nodeIdx*2; //X*2
				
				if(next==K) return visited[nodeIdx];
				
				if(next >=0 && next < visited.length && visited[next] == 0) { //아직 큐 안에 있고 값이 없다면
					q.offer(next); // 다음 시작(체크)을 idx를 큐에 넣는다.
					visited[next] = visited[nodeIdx]+1; // 해당 거리배열칸에 탐색시작한 노드의 +1을 더한다(1초 경과 후 움직였다는 증거 5에서 시작 6에 2(초)를 넣는다. 
				}
			}
		}
		
		return 0;
		
		
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		if(N==K) {
			sb.append(ans);
		} else {
			ans = BFS(N, K);
		}
		
		System.out.print(ans);
		
	}
}
