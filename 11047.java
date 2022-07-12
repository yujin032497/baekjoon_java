// 2022-07-12
// 동전 0

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	
	static int N,K;
	static Integer[] coins;
	
	public static void main(String[] args) throws IOException {
		
		int ans = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //동전 종류 개수
		K = Integer.parseInt(st.nextToken()); //금액
		
		coins = new Integer[N]; //동전 종류 배열
		
		for(int i=0; i<coins.length; i++) {
			coins[i] = Integer.parseInt(br.readLine()); //동전 종류 입력
		}
		
		Arrays.sort(coins, Collections.reverseOrder()); //동전 종류 배열 역순
		
		for(int i=0; i<coins.length; i++) {
			ans += K/coins[i]; //개수
			K%=coins[i]; //K = 금액 % 동전종류
		}
		
		System.out.println(ans);
	}
}
