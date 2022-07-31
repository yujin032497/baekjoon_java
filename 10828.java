// 2022-07-31
// 스택

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //입력할 명령어 수
		
		Stack<String> stack = new Stack<>(); //스택
		String cmd, N; //명령어
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(st.countTokens()==2) { //push 명령어 입력했을 경우
				cmd = st.nextToken();
				N = st.nextToken();
			} else { //그 외 명령어 입력했을 경우
				cmd = st.nextToken();
				N = "";
			}
			
			//스택 명렁어
			int ans = 0; //명령어를 통한 결과 값
			switch(cmd) {
			case "push":
				if(N.length()!=0) {
					stack.push(N);
				}
				break;
				
			case "pop":
				if(stack.size()==0) ans = -1;
				else ans = Integer.parseInt(stack.pop());
				break;
				
			case "size":
				ans = stack.size();
				//System.out.println(stack.size());
				break;
				
			case "empty":
				if(stack.empty()) ans=1;
				
				//System.out.println(ans);
				break;
				
			case "top":
				if(stack.empty()) ans=-1;
				else ans = Integer.parseInt(stack.peek());
				//System.out.println(ans);
				break;
			}
			
			if(cmd.equals("push") == false) System.out.println(ans);
		}
	}
}
