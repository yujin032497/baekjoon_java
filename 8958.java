// 2022-07-25
//OX퀴즈

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //테스트 케이스 수
		for(int i=0; i<N; i++) {
			int point=0, sum=0; //연속 O의 점수, 점수 합계
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				char c = str.charAt(j); //한 문자씩 읽기
				if(c=='O') { //O이면
					point++; //점수 1씩 증가
				} else {
					point = 0; //점수 0
				}
				sum+=point; //+1증가된 점수를 계속 더하기
			}
			
			System.out.println(sum); //출력
		}
		
	}

}
