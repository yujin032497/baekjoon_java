// 2022-08-03
// 펠린드롬수

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
    //0을 입력할 때까지 반복문 실행
		while(true) {
			
			String N = in.readLine();
			int ans = -1; //0 : 펠린드롬수X
			if(N.equals("0")) break; //0을 입력하면 반복문 종료
			
			for(int i=0; i<N.length()/2+1; i++) { //N길이/2+1이 정가운데를 의미한다. EX) 5/2+1 = 3
				if(N.charAt(i) == N.charAt(N.length()-i-1)) continue; // 앞쪽은 i가 증가할수록 뒤쪽방향으로, 뒤쪽은 i가 증가할수고록 앞쪽방향으로 읽어간다.
				else { //다른게 있다면
                    
					ans = 0; 
					break; //종료한다.
				}
			}
			
      //출력
			if(ans==0) System.out.println("no");
			else System.out.println("yes");
		}
	}
}
