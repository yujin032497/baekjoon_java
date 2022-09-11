// 2022-09-11
// 30

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	
	static String str;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		str = in.readLine();
		
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);
		
		int sum = 0;
		for(int i=charArr.length-1; i>=0; i--) {
			int num = charArr[i] - '0';
			sum += num;
			sb.append(num);
		}
		
		if(charArr[0]!='0' || sum%3!=0) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}
		
	}

}
