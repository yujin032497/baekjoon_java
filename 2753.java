// 2022-07-08
// 윤년

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String args[]) throws IOException {
		
		int year; //입력한 년도
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		year = Integer.parseInt(br.readLine());
		
		if((year%4==0 && year%100!=0)||(year%400==0)) { //윤년조건
			System.out.println('1');
		} else { System.out.println('0');}
	}
}
