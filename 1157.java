// 2022-07-15
// 단어 공부

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static String word; //단어
	static int [] alphabet = new int [26]; //알파벳 갯수: A~Z까지 26개 배열 생성
	public static void main(String args[]) throws IOException {
		
		int max = 0; //최대 갯수
		char chr = ' '; //최대 갯수 문자
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		word = br.readLine().toUpperCase(); //모든 문자를 대문자로
		
		for(int i=0; i<word.length(); i++) {
			
			alphabet[((int)word.charAt(i))-65]+=1; //문자->아스키코드로 변환 후 +1 
		}
		
		for(int i=0; i<alphabet.length; i++) {
			if(alphabet[i]>max) {
				max = alphabet[i];
				chr = (char)(i+65); //아스키코드->문자
			} else if(max!=0 && alphabet[i]==max) { //같은 갯수의 알파벳이 있다면
				chr = '?'; //?출력
			}
		}
		
		System.out.println(chr); //출력
	}

}
