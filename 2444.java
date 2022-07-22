// 2022-07-22
// 별 찍기 - 7

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//상
		for(int i=1; i<N; i++) {
			for(int j=N-i; j>0; j--) {
				System.out.print(" ");
			}
			for(int j=0; j<2*i-1; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
		//중간
		for(int i=0; i<2*N-1; i++) {
			System.out.print("*");
		}
		System.out.print("\n");
        
		//하
		for(int i=N-1; i>0; i--) {
			for(int j=i; j<N; j++ ) {
				System.out.print(" ");
			}
			for(int j=2*i-1; j>0; j--) {
				System.out.print("*");
			}
			
			System.out.print("\n");
		}
	}

}
