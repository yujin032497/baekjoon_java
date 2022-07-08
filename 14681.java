// 2022-07-08
// 사분면 고르기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		int x, y;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		x = Integer.parseInt(br.readLine()); //x좌표 입력
		y = Integer.parseInt(br.readLine()); //y좌표 입력
		
		if(x>0 && y>0) { //제1사분면
			System.out.println('1');
		} else if(x<0 && y>0) { //제2사분면
			System.out.println('2');
		} else if(x<0 && y<0) { //제3사분면
			System.out.println('3');
		} else if(x>0 && y<0) { //제4사분면
			System.out.println('4');
		}
	}

}
