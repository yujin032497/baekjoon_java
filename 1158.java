// 2022-08-08
// 요세푸스 문제

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static  void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String split[] = in.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int N = Integer.parseInt(split[0]);
		int K = Integer.parseInt(split[1]);
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		int i=1;
		while(!q.isEmpty()) {
			int n = 0;
			if(i!=K) {
				n= q.poll();
				q.offer(n);
				i++;
			} else {
				n = q.poll();
				sb.append(n+", ");
				i = 1;
			}
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb);
		
	}

}
