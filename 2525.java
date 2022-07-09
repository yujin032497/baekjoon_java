// 2022-07-09
// 오븐 시계

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		int A, B, C;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken()); //시
		B = Integer.parseInt(st.nextToken()); //분
		C = Integer.parseInt(br.readLine()); //요리하는 데 필요한 시간
		
		B+=C; //분 + 요리하는 데 필요한 시간
		
		if(B>=60) { //분이 60분이 넘으면
			A+=(B/60); //60을 나눈만큼 시에 더하기
			B%=60; //60의 나머지=>분
		}
		
		if(A>=24) { //시가 24시가 넘으면
			
			A%=24; //24의 나머지=>시
			
		}
		
		System.out.println(A+" "+B);
	}

}
