// 2022-10-20
// 돌 게임

import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int game = 1;
		
		while(true) {
			
			if(N>=3) N-=3;
			else if(N>=1) N-=1;
			
			if(N==0) break;
			++game;
		}
		
		if(game%2==0) System.out.println("CY");
		else System.out.println("SK");
	}
}
