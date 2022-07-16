// 2022-07-16
// 최댓값

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int [] N = new int [9]; //9개의 숫자 배열
	
	public static void main(String[] args) throws IOException {
		
		int max = 0, idx = -1; //최댓값, 인덱스
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
    //9개의 숫자 입력
		for(int i=0; i<9; i++) {
			N[i] = Integer.parseInt(br.readLine());
		}
		
    //최댓값구하기
		for(int i=0; i<N.length; i++) {
			if(N[i]>max) {
				max = N[i];
				idx = i+1;
			}
		}
		
    //출력
		System.out.println(max);
		System.out.println(idx);
	}

}
