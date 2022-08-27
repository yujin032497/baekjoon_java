// 2022-08-27
// 괄호 추가하기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static char[] expression;
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] twoSum = new int [N/2];
		expression = in.readLine().toCharArray();
		
		makeExpression(2, expression[0]-'0');
		System.out.println(ans);
	}
	
	

	private static void makeExpression(int now, int total) {
		// TODO Auto-generated method stub
		
		if(now>=expression.length) {
			ans = Math.max(ans, total);
			return;
		}
		
		makeExpression(now+2, calc(total, expression[now-1], expression[now]-'0'));
		
		
		if(now+2<expression.length) {
			int tmp = calc(expression[now]-'0', expression[now+1], expression[now+2]-'0');
			int sumTotal = calc(total, expression[now-1], tmp);
			makeExpression(now+4, sumTotal);
		}
		
		
	}



	private static int calc(int n1, char ch, int n2) {
		int rtn = 0;
		switch(ch) {
		case '+':
			rtn = n1+n2;
			break;
		case '-':
			rtn = n1-n2;
			break;
		case '*':
			rtn = n1*n2;
			break;
		}
		return rtn;
	}
}
