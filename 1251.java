// 2022-09-12
// 단어 나누기

/* StringBuilder를 활용하기!!!*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		
		String[] words = new String [3];
		ArrayList<String> list = new ArrayList<>();

		
		for(int i=1; i<str.length()-1; i++) {
			for(int j=i+1; j<str.length(); j++) {
				words[0] = str.substring(0, i);
				words[1] = str.substring(i, j);
				words[2] = str.substring(j, str.length());
				
				StringBuilder sb2 = new StringBuilder();
				
				for(int k=0; k<3; k++) {
					StringBuilder sb = new StringBuilder(words[k]);	
					sb2.append(sb.reverse().toString());
				}
				
				list.add(sb2.toString());
				
			}
			
		}
		
		Collections.sort(list);
		System.out.println(list.get(0));
	}
}
