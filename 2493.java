// 2022-08-06
// 탑

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {

	public static void main(String args[]) throws Exception {
		
		Stack<Integer> stack = new Stack<>(); //숫자 스택
		Stack<Integer> no = new Stack<>(); //인덱스 위치 스택
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine()); //숫자 개수
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] nums = new int [N+1]; //숫자배열
		
		for(int i=1; i<=N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}	
		
		int top = 0; //숫자 스택 탑 값
		for(int j=1; j<nums.length; j++) {
			
			if(stack.isEmpty()) { //숫자 스택이 비어있으면 무조건 push
				stack.push(nums[j]); //숫자 스택에 push
				no.push(j); //인덱스 스택에 push
				sb.append(0 + " ");
				
			} else {
				top = stack.peek(); //숫자 스택 탑 반환
				
				if(top > nums[j]) { //숫자 스택 탑 > 숫자배열 값
					sb.append(no.peek() + " "); //인덱스 스택 push 전 위치 출력
					stack.push(nums[j]); //숫자 스택 push
					no.push(j); //인덱스 스택 push
					
          // 숫자 스택 탑 > 숫자배열 값이 되기 전까지 pop()
				} else if(top < nums[j]) { //숫자 스택 탑 < 숫자배열 값
					stack.pop(); //숫자 스택 pop
					no.pop(); //인덱스 스택 pop
					j--; //루프 -1 전으로
					continue; 넘김
				}
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}

}
