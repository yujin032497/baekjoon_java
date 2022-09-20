// 2022-09-21
// X보다 작은 수

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X  = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int[] A = new int [N];
		
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			if(X>A[i]) System.out.print(A[i]+ " ");
		}
	}

}
