// 2022-07-30
// A+B - 5

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A, B;
		while(true) { //무한 반복
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			if(A==0 & B==0) return; //A,B 둘다 0일경우 반복문 종료
			
			System.out.println(A+B);
		}
		
	}
}
