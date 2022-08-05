// 2022-08-05
// 나머지 합

*****
//(A+B)&M == ((A%M) + (B&M))%M

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long [] arr = new long [N]; //구간합배열(자료형을 long으로 범위가 10^6)
		long [] C = new long[M]; //나머지 배열(자료형을 long으로 범위가 10^6)
		int remainder = 0;
		long answer = 0; //정답
		
		//초기세팅
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//구간합배열
		for(int i=1; i<N; i++) {
			arr[i] = arr[i-1]+arr[i];
		}
		
		//구간합에 대한 나머지 구하기
		for(int i=0; i<N; i++) {
			remainder = (int) (arr[i]%M); //나머지는 int로 명시적형변환
			C[remainder]++;
			
			if(remainder == 0) answer++; //단독으로 나누어 떨어지는 개수 세기
		}
		
		//나머지에 따른 경우의 수: 0 =>3C2, 1=>2C2
		for(int i=0; i<M; i++) {
			answer += C[i]*(C[i]-1)/2;
		}
		
		System.out.println(answer);
		
	}
}
