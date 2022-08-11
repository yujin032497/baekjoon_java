// 2022-08-11
// 배수와 약수

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] split = in.readLine().split(" ");
			
      /* 두 수를 입력받는다*/
			int A = Integer.parseInt(split[0]);
			int B = Integer.parseInt(split[1]);
			
			if(A==0 & B==0) break; // 둘 다 0이면 반복문 종료
			
			String ans = ""; // factor, multiple, neither 중 값을 받는다.
			
			if(A < B) { // A가 B보다 작으면 A가 B의 약수 factor 
				if(B%A==0) ans = "factor";
			}
			else if(A >= B) { // A가 B보다 크거나 같으면 A가 B의 배수 multiple 할당
				if(A%B==0) ans = "multiple";
			}
			
			if(ans.equals("")) ans = "neither"; // 둘 다 조건이 아니라면 neiter 값 할당
			
			System.out.println(ans);
		}
	}

}
