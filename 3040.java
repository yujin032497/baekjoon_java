// 2022-08-11
// 백설 공주와 일곱 난쟁이

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N = 9; // 모자 수
	static int M = 7; // 뽑을 모자 수
	static boolean visited[] = new boolean [N]; // 방문 체크 배열
	static int totalCnt = 0; // 모자에 적힌 숫자 합
	static int[] data; // 모자에 적힌 숫자 데이터 배열
	static int[] ans; // 정답 배열
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		data = new int [N];
		ans = new int [M];
		for(int i=0; i<N; i++) {
			data[i] = Integer.parseInt(in.readLine());
		}
		
		perm(0); // 조합 수행
		
		for(int i=0; i<M; i++) {
			System.out.println(ans[i]);
		}
	}
  
  /*조합메서드*/
	private static void perm(int cnt) {
		
		if(cnt==M) { // 7개를 모두 골랐다면
			totalCnt = 0;
			
			for(int i=0; i<M; i++) {
				totalCnt+=ans[i]; // 고른 모자의 수를 모두 더한다.
			}
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) { // 방문했으면
				continue; // 넘긴다
			}	
			
      // 방문하지 않았으면
			ans[cnt] = data[i]; // 정답배열에 데이터를 넣어주고 
			visited[i] = true; // 방문 체크
			
			perm(cnt+1); // 카운터 1증가로 메서드 호출
			
			if(totalCnt==100) return; // 모자 숫자의 합이 100이면 메서드 종료
			visited[i] = false; // 숫자의 합이 100이 안되면 방문 체크 해제
		}
		
	}

}
