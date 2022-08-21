// 2022-08-21
// 일우는 야바위꾼

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		int N = Integer.parseInt(split[0]);
		int X = Integer.parseInt(split[1]);
		int K = Integer.parseInt(split[2]);
		
		int[] cups = new int [N+1];
		cups[X] = 1;
		
		for(int i=0; i<K; i++) {
			split = in.readLine().split(" ");
			int cup1 = Integer.parseInt(split[0]);
			int cup2 = Integer.parseInt(split[1]);
			
			int tmp = cups[cup1];
			cups[cup1] = cups[cup2];
			cups[cup2] = tmp;
		}
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			if(cups[i]==1) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
	}

}
