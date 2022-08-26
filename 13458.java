// 2022-08-26
// 시험 감독

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[] classes;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(in.readLine());
		
		classes = new long [N+1];
		
		// 시험장
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=N; i++) {
			classes[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		long B = Integer.parseInt(st.nextToken()); // 총감독관이 감독할 수 있는 인원 수
		long C = Integer.parseInt(st.nextToken()); // 부감독관이 감독할 수 있는 인원 수
		
		long ans = 0; // 필요한 총 감독관 수
		for(int i=1; i<=N; i++) {
			long n = classes[i];
			n-=B; // 총감독관이 감독할 수 있는 인원 수 빼기
			ans++;
			if(n<=0) continue;
			if(n%C!=0) { // 부감독관이 감독할 수 있는 인원 수 구하기
				ans+=n/C+1;
			} else ans += n/C;
		}
		
		System.out.println(ans);
	}
}
