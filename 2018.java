// 2022-08-06
// 수들의 합

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine()); // 자연수 N
		
		int start = 1, end = 1, sum = 1; //start 위치, end 위치, 수들의 합계
		int count = 1; // 카운터(15 혼자 한개의 경우 미리 계산)
		
		while(start < N-1 | end > N) {
			
			if(N < sum) { // N이 sum보다 작으면(N보다 크므로 투 포인터 범위를 줄인다)
				sum-=start; //현재 start만큼 sum에서 뺀다.
				start++; //start위치 +1 증가
			}
			else if (N > sum) { // N이 sum보다 크면(N보다 작으므로 투 포인터 범위를 늘인다)
				end++; //현재 end위치 +1 증가
				sum+=end; //1증가한 end를 sum에 더한다
			}else { // N과 sum이 같을경우(N과 같으므로 카운터 1증가하고 투 포인터 범위를 늘인다)
				count++; //카운터 1증가
				end++; //end위치 +1 증가
				sum+=end;//1증가한 end를 sum에 더한다
			}
		}
		
		System.out.println(count);
	}

}
