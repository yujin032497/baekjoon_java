// 2022-10-20
// 핸드폰 번호 궁합

import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] phone1 = in.readLine().toCharArray();
		char[] phone2 = in.readLine().toCharArray();
		
		int [][] dp = new int [15][16];
		
		int idx = 0;
		for(int i=0; i<16; i+=2) {
			dp[0][i] = phone1[idx]-'0';
			dp[0][i+1] = phone2[idx]-'0';
			++idx;
		}
		
		for(int i=1; i<15; i++) {
			for(int j=0; j<15; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i-1][j+1])%10;
			}
		}
		
		System.out.printf("%d%d",dp[14][0],dp[14][1]);
	}
}
