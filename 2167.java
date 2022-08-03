// 2022-08-03
// 2차원 배열의 합

// =>2차원배열은 1. 가로로 누적합, 2.세로로 누적합
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][M+1];
		
    //가로로 누적합
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=M; j++) {
				dp[i][j] = dp[i][j-1]+Integer.parseInt(st.nextToken());
			}
		}
		
    //세로로 누적합
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j];
			}
		}
		
		int K = Integer.parseInt(in.readLine());
		
		for(int k = 0; k<K; k++) {
			st = new StringTokenizer(in.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
      // 구하려는 범위의 위로 1칸, 왼쪽 한칸 만큼의 누적합을 뺀 후 위쪽, 왼쪽 공통으로 빠지는 수 한번 더해주기
      // 이중으로 뺐기 때문이다.
			int ans = dp[x][y] - dp[i-1][y] - dp[x][j-1] + dp[i-1][j-1];
			
			System.out.println(ans);
		}
		
	}
}
