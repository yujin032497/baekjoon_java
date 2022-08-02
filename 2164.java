//2022-08-03
//카드2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		Queue<Integer> queue= new LinkedList<>(); //큐를 활용한다.
		
		for(int i=1; i<=N; i++) {
			queue.add(i); //1~N까지의 수를 큐에 넣는다.
		}
	
		if(queue.size()>1) { //큐 사이즈가 1보다 크면(커야 카드를 삭제하고 뒤로 돌린다.)
		
			while(true) {
				queue.remove(); //제거하고
				
				if(queue.size()==1) break; //큐 사이즈가 1이면 반복문 종료
				
				int next = queue.poll(); //꺼내고
				queue.offer(next); //뒤로 넣는다. (add와 offer의 차이 => add: 실패하면 에러발생, offer: 실패하면 false 반환값)
			}
		}
		int ans = queue.poll(); //큐에 한 장 남을 시 꺼내서
		System.out.println(ans);
	}
}
