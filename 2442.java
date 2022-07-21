// 2022-07-21
// 별 찍기 - 5

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<N-1-i; j++) {
				System.out.print(" ");
			}
			
			if(i==0) { 
				System.out.print("*"); 
			} else {
				for(int j=0; j<i+1; j++) {
					System.out.print("*");
				}
				for(int j=0; j<i; j++) {
					System.out.print("*");
				}
			}
			
			System.out.print("\n");
		}
	}

}
