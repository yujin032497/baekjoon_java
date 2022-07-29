//2022-07-29
//아스키 코드

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char ch = br.readLine().charAt(0); //첫 번째 문자를 가져온다.
		System.out.print((int) ch); //(int) 명시적 형변환을 통해 아스키코드 
	}
}
