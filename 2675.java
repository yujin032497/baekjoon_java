// 2022-07-16
// 문자열 반복

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int T; //테스트케이스 수
	
	public static void main(String[] args) throws IOException {
		
		int R; //문자 반복 횟수
		String S, P; //기존 문자열, 문자 반복한 문자열
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
    //문자열 입력
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			S = st.nextToken();
			P = "";
      //문자 반복을 통한 문자열 생성
			for(int j=0; j<S.length(); j++) {
				for(int k=0; k<R; k++) {
					P += S.charAt(j);
				}
			}
			
      //출력
			System.out.println(P);
		}
	}

}
