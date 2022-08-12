// 2022-08-12
// 절댓값 힙

package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() { // 우선순위 큐 활용
     
      // 절댓값 비교로 정렬 재정의, 절댓값이 서로 같으면 오름차순으로 정렬
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(Math.abs(o1)==Math.abs(o2)) { // 절댓값이 같으면
					if(o1>o2) return 1; // 원래 숫자 오름차순으로 정렬
					else if(o1<o2) return -1;
					else return 0;
				}
				else return Math.abs(o1) - Math.abs(o2); // 절댓값이 다르면 절댓값으로 오름차순 정렬
			}
			
		});
		
		
		int N = Integer.parseInt(in.readLine());
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(in.readLine());
			if(n==0) { // 입력값이 0 일 경우
				if(pq.isEmpty()) sb.append(0).append("\n"); // 큐가 비어져 있으면 0 출력
				else sb.append(pq.poll()).append("\n"); // 데이터가 있으면 데이터를 끄집어낸다.
			} else { // 입력값이 0이 아니면
				pq.offer(n); // 큐에 값을 넣는다.
			}
			
		}
		System.out.print(sb);
		
		
	}

}
