// 2022-08-19
// 최대 힙

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main{
	
	public static void main(String[] args) throws Exception {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(in.readLine());
			if(num==0) {
				if(pq.isEmpty()) sb.append(0).append("\n");
				else sb.append(pq.poll()).append("\n");
			} else pq.offer(num);
		}
		
		System.out.println(sb);
	}

}
