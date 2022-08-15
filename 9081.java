// 2022-08-15
// 단어 맞추기

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;
	static String str;
	static String sTmp;
	static int N;
	static int[] alphabet;

	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case<=T; test_case++) {
			
			str = in.readLine();
			
			N = str.length();
			alphabet = new int [26];
			int idx = Integer.MIN_VALUE;
			int cnt = 0;
			boolean tag = false;
			
			for(int i=N-1; i>=1; i--) {
				idx = str.charAt(i)-'A';
				alphabet[idx]++;
				cnt++;
				if(idx > str.charAt(i-1)-'A') {
					idx = str.charAt(i-1)-'A';
					alphabet[idx]++;
					cnt++;
					tag = true;
					break;
				}
			}
			
			if(tag == true) {
				String sTmp = "";
				for(int i=0; i<N-cnt; i++) {
					sTmp+=str.charAt(i);
				}
				
				//System.out.println((char)(start+'A') );
				// 시작보다 큰거 출력
				for(int i=idx+1; i<26; i++) {
					if(alphabet[i]!=0) {
						sTmp += ((char) (i+'A'));
						alphabet[i]--;
						break;
					}
				}
				
				for(int i=0; i<26; i++) {
					if(alphabet[i]!=0) {
						sTmp+=((char) (i+'A'));
						alphabet[i]--;
						i--;
					}
				}
				
				sb.append(sTmp);
				
			} else {
				sb.append(str);
			}

			sb.append("\n");
		}
		System.out.print(sb);
	}

}
