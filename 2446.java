// 2022-07-24
//별 찍기 - 9

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
    상부
		for(int i=0; i<N; i++) {
			
			if(i==0) {
				for(int j=1; j<=2*N-1; j++) {
					System.out.print("*");
				}
			} else {
				for(int j=0; j<i; j++) {
					System.out.print(" ");
				}
				for(int j=0; j<2*N-(2*i)-1; j++) {
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
		
    //하부
		for(int i=1; i<N; i++) {
			for(int j=N-i; j>1; j--) {
				System.out.print(" ");
			}
			for(int j=0; j<2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
			
	}

}
