// 2022-08-07
// 캠핑

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] split;
		
		int T = 1; // 테스트 케이스 수
		
		while(true) {
			
			split = in.readLine().split(" ");
			
			int P = Integer.parseInt(split[0]); // 캠핑을 연속하는 일 수
			int L = Integer.parseInt(split[1]); // 캠핑을 사용할 수 있는 일 수
			int V = Integer.parseInt(split[2]); // 강산이 휴가 일 수
			
			if(P==0 && L==0 && V==0) break;
			
			sb.append("Case " + T + ": ");
			
			int day = 0; // 실제 사용 일 수
			
			if(P <= L) { // 캠핑을 연속하는 일 수 = 실제 사용할 수 있는 일 수
				day+=P*(V/L);
				V = V-((V/L)*L);
			} else { // 
				day+=L*(V/P); // 캠핑을 사용할 수 있는 일 수 = 실제 사용할 수 있는 일 수
				V = V-((V/P)*P);
			}
			
			if(V > P) day+=P; // 남은 잔여 일 수 > 캠핑을 연속하는 일 수 => 캠핑을 연속하는 일 수 = 실제 사용할 수 있는 일 수
			else day+=V; // 남은 잔여 일 수 < 캠핑을 연속하는 일 수 => 남은 잔여 일 수 = 실제 사용할 수 있는 일 수
			
			
			sb.append(day + "\n");
			T++;
		}
		
		System.out.print(sb);
	}
}
