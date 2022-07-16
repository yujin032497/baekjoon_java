// 2022-07-16
// 음계

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String asc = "12345678"; //오름차순 문자열
	static String des = "87654321"; //내림차순 문자열
	
	public static void main(String args[]) throws IOException {
		
		String s, ans; //입력받은 문자열, 정답
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		s = s.replaceAll("\\s", ""); //모든 공백 제거
		
		if(s.equals(asc)) { //입력한 문자열이 오름차순이면
			ans = "ascending";
		} else if(s.equals(des)) { //입력한 문자열이 내림차순이면
			ans = "descending";
		} else { //입력한 문자열이 오름차순, 내림차순 둘 다 아니면
			ans = "mixed";
		}
		
    //
		System.out.println(ans);
		
		
	}
}
