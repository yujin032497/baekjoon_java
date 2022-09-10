// 2022-09-11
// 박 터트리기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] basket = new int [K];
		int ans = 0;
		
		for(int i=1; i<=K; i++) {
			basket[i-1] = i;
		}
		
		if(N < (K*(K+1))/2) {
			System.out.println(-1);
		}
		else {
			int share = (N - (K*(K+1))/2)/K;
			int remainder = (N - (K*(K+1))/2)%K;
			
			if(remainder>0) {
				System.out.println((basket[K-1]+share+1) - (basket[0]+share) );
			} else {
				System.out.println((basket[K-1]+share) - (basket[0]+share));
			}
		}
	}

}
