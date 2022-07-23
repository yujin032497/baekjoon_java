// 2022-07-24
// 별 찍기 - 8

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
    //상부
		for(int i=1; i<=N; i++) {
			if(i==N) { //가운데
        for(int j=0; j<N*2; j++) {
					System.out.print("*");
				}
			} else {
				for(int j=0; j<i; j++) {
					System.out.print("*");
				}
				for(int j=i; j<N*2-i; j++) {
					System.out.print(" ");
				}
				
				for(int j=0; j<i; j++) {
					System.out.print("*");
				}
			}

			System.out.println();
		}

    //
		for(int i=1; i<=N; i++) {
			
			for(int j=0; j<N-i; j++) {
				System.out.print("*");
			}
			for(int j=0; j<i*2; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<N-i; j++) {
				System.out.print("*");
			}
		
			System.out.println();
		}
	}
}
