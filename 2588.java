// 2022-07-05
// 곱셈

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		int A,B;
		int u,t,h; //일의자리, 십의자리, 백의자리 각 자리수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		h = B/100;
		t = (B-(h*100))/10;
		u = B-(h*100)-t*10;
		System.out.println(A*u);
		System.out.println(A*t);
		System.out.println(A*h);
		System.out.println(A*u+A*t*10+A*h*100);
	}

}
