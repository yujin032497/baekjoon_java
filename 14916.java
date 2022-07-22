// 2022-07-22
// 거스름 돈

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
		static int[] coins = {2, 5}; //동전 목록
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] counts = new int [2]; //2원(coins[0]), 5원 개수(coins[1]) 배열
		int sum = 0; //동전 최소 합계 수
		
		while(n!=0) {
			
			if(n%coins[1] == 0) { //5원짜리가 나눠질 경우
				n-=coins[1]; //5원을 빼준다.
				counts[1]++; //5원 개수 +1
			} else if (n>=coins[0]){ //입력한 동전이 2원보다 클 경우
				n-=coins[0]; //2원을 빼준다.
				counts[0]++; //2원 개수 +1
			} else { //거슬러 줄 수 없다면
				sum = -1; //-1
				break;
			}
		}
		
    
		if(sum!=-1) {//최소 합계가 -1이 아니면
			sum = Arrays.stream(counts).sum();
		}
		System.out.println(sum); //
	}
}
