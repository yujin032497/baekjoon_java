// 2022-07-27
// 5와 6의 차이

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken(); //두 수를 입력한다.
		String B = st.nextToken();
		
		A = A.replace('6', '5'); //6을 5로 바꾼다.
		B = B.replace('6', '5');
		int min = Integer.valueOf(A)+Integer.valueOf(B); //6을 5로 전부 바꾼 값이 최솟값
		
		A = A.replace('5', '6'); //5를 6으로 바꾼다.
		B = B.replace('5', '6');
		
		int max = Integer.valueOf(A)+Integer.valueOf(B); //5를 6으로 전부 바꾼 값이 
		
		System.out.print(min + " " + max);
	}

}
