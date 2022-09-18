// 2022-09-18
// 과제 안 내신 분..?

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean [] students = new boolean [31];
		
		for(int i=0; i<28; i++) {
			int num = Integer.parseInt(in.readLine());
			students[num] = true;
		}
		
		for(int j=1; j<=30; j++) {
			if(!students[j]) System.out.println(j);
		}
	}
}
