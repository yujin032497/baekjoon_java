// 2022-08-25
// 팰린드롬 만들기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
	
		int[] alphabet = new int [26];
		
		for(int i=0; i<str.length(); i++) {
			alphabet[str.charAt(i)-'A']++;
		}
		
		int oddCnt = 0;
		for(int i=0; i<26; i++) {
			if(alphabet[i]%2!=0) oddCnt++;
		}
		
		if(oddCnt>1) System.out.println("I'm Sorry Hansoo");
		else {
			String front="",mid="",end="";
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<26; i++) {
				int cnt = alphabet[i]/2;
				for(int j=0;j<cnt;j++) {
					front+=(char) (i+'A');
					alphabet[i]-=2;
				}
				if(alphabet[i]!=0 && alphabet[i]%2!=0) {
					mid+= (char) (i+'A');
				}
			}
			
			end = sb.append(front).reverse().toString();
			
			System.out.println(front+mid+end);	
		}
		
	}

}
