// 2022-07-24
// 숫자의 합

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N개의 숫자 입력
		int sum = 0; // 숫자들의 합
		
		String nums = br.readLine(); //여러숫자 입력
		
		for(int i=0; i<N; i++) { //N개의 숫자를
			sum+= nums.charAt(i) - '0'; //sum 변수에 하나씩 추출하여 
		}
		
		System.out.print(sum);
	}
}
