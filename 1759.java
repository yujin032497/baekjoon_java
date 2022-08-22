// 2022-08-22
// 암호 만들기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static StringBuilder sb;
	static int L,C;
	static char[] alphabet;
	static char[] select;
	static char[] mo = {'a','e','i','o','u'};
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] split = in.readLine().split(" ");
		
		L = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);
		
		alphabet = new char [C];
		select = new char [L];
		
		split = in.readLine().split(" ");
		for(int i=0; i<C; i++) {
			alphabet[i] = split[i].charAt(0);
		}
		
		Arrays.sort(alphabet);
		comb(0,0);
		System.out.println(sb);
	}
	private static void comb(int start, int count) {
		// TODO Auto-generated method stub
		
		if(count==L) {
			int moCnt = 0, jaCnt = 0;
			String str = "";
			for(int i=0; i<L; i++) {
				str += select[i];
			}
			
			for(int i=0; i<mo.length; i++) {
				if(str.contains(String.valueOf(mo[i]))) moCnt++;
			}
			
			if(moCnt<1) return;
			
			jaCnt = count - moCnt;
			
			if(jaCnt<2) return;
			
			sb.append(str).append("\n");
			return;
			
		}
		
		for(int i=start; i<C; i++) {
			select[count] = alphabet[i];
			comb(i+1, count+1);
		}
	}

}
