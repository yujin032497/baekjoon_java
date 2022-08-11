// 2022-08-11
// 도영이가 만든 맛있는 음식

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int N; // N개의 재료
	static int [][] SB; //[0]:신맛, [1]:쓴맛
	static boolean[] visited; // 방문체크 배열
	static int ans; // 최솟값(정답)

	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		SB = new int [N][2];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			
			String[] split = in.readLine().split(" ");
			SB[i][0] = Integer.parseInt(split[0]);
			SB[i][1] = Integer.parseInt(split[1]);
		}
		
		ans = Integer.MAX_VALUE; // 최솟값 출력이므로 최대값으로 초기화
		subset(0); // 부분집합 수행
		
		System.out.println(ans);
	}

  /* 부분집합 함수*/
	private static void subset(int idx) {
			if(N==idx) {
				
				int mulS = 1; // 신맛 곱
				int sumB = 0; // 쓴맛 합
				int cnt = 0; // true 개수
                     // true 개수를 카운트 하지 않으면 모두 고르지 않을 때 최솟값이 1로 할당됨.
				
				for(int i=0; i<N; i++) {
					if(visited[i]) {
						mulS*=SB[i][0];
						sumB+=SB[i][1];
						cnt++;
					}
				}
				
				if(cnt!=0) ans = Math.min(ans, Math.abs(mulS-sumB)); // 방문체크 배열에서 true가 존재할 때 최솟값 계산
                                                             // 신맛 - 쓴맛의 값이 음수일 경우도 있으므로 절대값으로 비교
				return;
			}
		
		visited[idx] = true;
		subset(idx+1);
		
		visited[idx] = false;
		subset(idx+1);
		
	}
}
