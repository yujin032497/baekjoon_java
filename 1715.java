// 2022-08-07
// 카드 정렬하기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine()); // 카드 묶음 수
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 값이 낮은 순으로 오름차순 정렬
		
		for(int i=0; i<N; i++) {
			pq.add(Integer.parseInt(in.readLine())); // 우선 순위 큐에 넣는다.
		}
		
		int sum = 0, ans = 0; //sum: 두 수 합계, ans: 총계
		
		while(pq.size()!=1) { // 우선 순위 큐 사이즈가 1이 될 때까지
			int A = pq.poll(); // 제일 첫 번째 요소 pop
			int B = pq.poll(); // 두 번째 요소 pop
			sum = A+B; // 두 수를 합한 후
			ans += sum; // 합한 값을 더하고
			pq.add(sum); // 다시 우선순위 큐에 넣는다.
		}
		
		System.out.println(ans);
	}
}
