// 2022-08-09
// 잃어버린 괄호

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split("-"); //-를 기준으로 문자열을 자른다.
		
		int min = 0; //최솟값
		
		for(int i=0; i<split.length; i++) {
			String[] splitPlus = split[i].split("[+]"); //자른 문자열안에 +를 기준으로 자른다.
			int tmp = 0;
			for(int j=0; j<splitPlus.length; j++) {
				tmp+=Integer.parseInt(splitPlus[j]); // + 기준으로 자른 숫자를 모두 더한다.
			}
			if(i==0) min+=tmp; // 처음과 마지막 숫자는 무조건 숫자로 시작하므로 양수(+)이다.
                         // 따라서 최솟값에 더해준다.
			else min-=tmp; // 이후에 - 등장으로 최솟값에서 빼준다.
		}
		
		System.out.println(min);
	}

}
