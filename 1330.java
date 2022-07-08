// 2022-07-08
// 두 수 비교하기

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException {
		
		int A,B;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		if(A>B) {
			System.out.println(">");
		} else if(A<B) {
			System.out.println("<");
		} else System.out.println("==");
	}
}
