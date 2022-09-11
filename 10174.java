// 2022-09-12
// 펠린드롬

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		for(int j=0; j<N; j++) {
			
			String str = in.readLine();
			str = str.toUpperCase();
			
			boolean isPalin = true;
			String ans = "";
			
			for(int i=0; i<str.length()/2; i++) {
				
				char ch = str.charAt(i);
				if(ch!=str.charAt(str.length()-1-i)) {
					isPalin = false;
					break;
				}
			}
			if(isPalin) ans = "Yes";
			else ans = "No";
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
}
