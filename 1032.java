// 2022-08-20
// 명령 프롬프트

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		String[] cmd = new String [N];
		String ans = "";
		
		for(int i=0; i<N; i++) {
			cmd[i] = in.readLine();
		}
		
		for(int i=0; i<cmd[0].length(); i++) {
			char ch = cmd[0].charAt(i);
			String sTmp = "";
			for(int j=1; j<N; j++) {
				sTmp = "";
				if(ch!=cmd[j].charAt(i)) {
					sTmp = "?";
					break;
				}
			}
			
			if(sTmp.equals("")) ans+=Character.toString(ch);
			else ans+=sTmp;
		}
		
		System.out.println(ans);
	}

}
