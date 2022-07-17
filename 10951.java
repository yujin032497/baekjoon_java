// 2022-07-17
// A+B - 4

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		int A = 0, B = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		while((str = br.readLine()) != null)  { //str 문자열 변수에 입력한 문자를 할당하여 null인지 확인
			
			StringTokenizer st = new StringTokenizer(str, " "); //null이 아니라면 해당 문자열을 " "으로 구분
			
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			System.out.println(A+B);
		}

	}

}
