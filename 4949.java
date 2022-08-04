// 2022-08-04
// 균형잡힌 세상

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        while(true) {
            
            String str = in.readLine();
            if(str.equals(".")) break; // .을 입력하면 반복문 종료
		

            Stack<Character> stack = new Stack<>();
            String ans = ""; //정답문

            for(int i=0; i<str.length(); i++) {

                char ch = str.charAt(i); // 한 글자를 받아온다.
                if(stack.isEmpty()) { // 스택이 비어져있으면 
                	if(ch=='('||ch==')'||ch=='['||ch==']') stack.add(ch); // 해당 기호에 해당하면 무조건 스택에 넣는다.
                }
                else {
                	if(ch=='(' || ch=='[') stack.add(ch); // 열린괄호는 스택에 넣는다.
                	else { //닫힌괄호거나 문자라면
                    	if (ch == ')' || ch ==']') { // 그 중에 닫힌괄호라면
                        char top = stack.peek(); // 스택 제일 위에 있는 값을 받아온다.
                        if(top=='(' & ch==')') stack.pop(); // 서로 괄호가 짝이 맞으면 pop() 한다.
                        else if (top=='[' & ch==']') stack.pop();
                        else break; // 그외 괄호가 짝이 맞지 않으면 반복문을 종료한다.
	                    }
	                }
                }
            }

            if(!stack.isEmpty()) ans = "no"; // 스택에 잔여 데이터가 있으면 "no"
            else ans = "yes"; // 스택에 잔여 데이터가 없으면 "yes"

            sb.append(ans + "\n");
        }
		System.out.print(sb);
	}

}
