// 2022-08-07
// 캥거루 세마리2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=in.readLine())!=null) { // 입력값이 null일 때 종료
			
      // 0 < A < B < C
			StringTokenizer st = new StringTokenizer(s);
			int A = Integer.parseInt(st.nextToken()); 
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			int max = 0;
			if(max < B-A-1) max = B-A-1; // -1을 하는 이유 => EX) 3 - 2 = 1이지만 2와 3사이에 공간 없음X
			if(max < C-B-1) max = C-B-1;
			
			
			System.out.println(max);
		
		}
	}

}
