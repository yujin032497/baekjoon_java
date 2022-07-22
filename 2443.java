// 2022-07-22
// 별 찍기 - 6

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int a = 1, b = 0;
		
		for (int i = N; i>0; i--) {
			
			for(int j = 0; j<b; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j<2*N-a; j++) {
				System.out.print("*");
			}

			a+=2;
			b++;
			System.out.print("\n");
		}
	}

}
