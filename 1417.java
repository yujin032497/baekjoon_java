// 2022-08-20
// 국회의원 선거

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int ans = 0;
		int[] person = null;
		
		if(N==1) ans = 0;
		else {
			person = new int [N-1];
			
			int dasom = Integer.parseInt(in.readLine());
			
			for(int i=0; i<N-1; i++) {
				person[i] = Integer.parseInt(in.readLine());
			}
			
			while(true) {
				Arrays.sort(person);;
				if(dasom <= person[person.length-1]) {
					dasom++;
					person[person.length-1]--;
					ans++;
				} else {
					break;
				}
			}
		}
		
		
		
		System.out.println(ans);
		
	}

}

