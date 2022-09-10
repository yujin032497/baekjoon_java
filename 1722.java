// 2022-09-11
// 순열의 순서

// 이 문제는 dp로 풀어야함
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, Q;
	static long[] F = new long[21]; // N이 1부터 20까지 주어짐
	static int[] S = new int [21];
	static boolean[] visited = new boolean[21];
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		Q = Integer.parseInt(st.nextToken());
		F[0] = 1;
		
		for(int i=1; i<=N; i++) {
			F[i] = F[i-1] * i; // 순열 가짓수( 팩토리얼 초기화 )
		}
		
		if(Q==1) { // 소문제 1번이면
			
			long K = Long.parseLong(st.nextToken());
			for(int i=1; i<=N; i++) {
				for(int j=1, cnt=1; j<=N; j++) {
					if(visited[j]) continue;
					
					if(K <= cnt * F[N-i]) {
						K-= ((cnt - 1) * F[N-i]);
						S[i] = j;
						visited[j] = true;
						break;
					}
					
					cnt+=1;
				}
			}
			
			for(int i=1; i<=N; i++) {
				System.out.print(S[i]+ " ");
			}
		} else {
			
			long K = 1;
													
			for(int i=1; i<=N; i++) {
				
				S[i] = Integer.parseInt(st.nextToken());
				
				long cnt = 0;
				
				for(int j=1; j<S[i]; j++) {
					
					if(!visited[j]) {
						cnt+=1;
					}
				}
				
				K += cnt * F[N-i];
				visited[S[i]] = true;
			}
			
			System.out.println(K);
		}
	}

}
