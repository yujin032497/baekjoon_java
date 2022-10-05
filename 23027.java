// 2022-10-05
// 1번부터 문제의 상태가...?

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		
		int idx = str.indexOf('A');
		if(idx == -1) {
			idx = str.indexOf('B');
			if(idx == -1) {
				idx = str.indexOf('C');
				if(idx == -1) {
					int N = str.length();
					str = "";
					for(int i=0; i<N; i++) {
						str+='A';
					}
				} else {
					str=str.replace('D', 'C');
					str=str.replace('F', 'C');
				}
			} else {
				str=str.replace('C', 'B');
				str=str.replace('D', 'B');
				str=str.replace('F', 'B');
			}
		} else {
			str=str.replace('B', 'A');
			str=str.replace('C', 'A');
			str=str.replace('D', 'A');
			str=str.replace('F', 'A');
		}
		System.out.println(str);
	} 

}

