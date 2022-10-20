// 2022-10-21
// 피보나치 수 4
// BigInteger 활용 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		BigInteger [] dp = new BigInteger [10001];
		
		dp[0] = new BigInteger("0");
		dp[1] = new BigInteger("1");
		
		for(int i=2; i<=10000; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		
		System.out.println(dp[N]);
	}
}
