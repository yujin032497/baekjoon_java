// 2022-09-12
// !밀비 급일

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			String str = in.readLine();
			
			if(str.equals("END")) break;
			
			StringBuilder sb = new StringBuilder(str);
			sb.reverse().toString();
			
			System.out.println(sb);
		}
	}

}
