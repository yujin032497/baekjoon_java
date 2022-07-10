// 2022-07-10
// 거스름돈

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		int [] money = {500, 100, 50, 10, 5, 1}; //
		int N; //물건 값
		int count=0; //잔액 동전 개수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 1000-Integer.parseInt(br.readLine()); //1000에서 물건 값을 뺀 잔액
		
		for(int i=0; i<6; i++) {
			
			count+=(N/money[i]);
			N%=money[i];
		}
		
		System.out.println(count);
		
	}

}
