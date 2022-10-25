// 2022-10-26
// 빗물

import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] block = new int [M];
		
		st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<M; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for(int i=0; i<M; i++) {
			int current = block[i];
			int left = current;
			int right = current;
			
			for(int j=i; j>=0; j--) {
				left = Math.max(left, block[j]);
			}
			
			for(int j=i; j<M; j++) {
				right = Math.max(right, block[j]);
			}
			
			if(Math.min(left, right) - current > 0) {
				ans += Math.min(left, right) - current;
			}
		}
		
		System.out.println(ans);
	}
}
