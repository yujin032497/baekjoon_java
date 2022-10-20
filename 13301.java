// 2022-10-21
// 타일 장식물

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		BigInteger dp[] = new BigInteger[81];
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		
		System.out.println(dp[N].multiply(new BigInteger("2")).add(dp[N-1].multiply(new BigInteger("2"))));
	}
}
