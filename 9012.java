// 2022-07-31
// 괄호

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String args[]) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			Stack<String> stack = new Stack<>();
			String st = br.readLine();
			
			//스택에 입력한 괄호 넣기
			for(int j=0; j<st.length(); j++) {
				if(stack.size() !=0 ) {
					if(stack.peek().equals("(") && st.valueOf(st.charAt(j)).equals(")")) {
						stack.pop();
					} else {
						stack.push(st.valueOf(st.charAt(j)));
					}
				} else {
					stack.push(st.valueOf(st.charAt(j)));
				}
			}
			
            //스택이 비어있는지 확인
			if(stack.empty()) {
				System.out.println("YES");
			} else System.out.println("NO");
			
		}
	}
}
