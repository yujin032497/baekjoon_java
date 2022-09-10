// 2022-09-10
// 하노이 탑 이동순서

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int count;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		count = 0;
		
		hanoi(1,2,3,N);
		System.out.println(count);
		System.out.println(sb);
	}

	// 시작점, 임시점, 목적점, n번쨰 원판
	private static void hanoi(int from, int m, int to, int n) {
		
		if (n==0) return;
		
		hanoi(from, to, m, n-1);
		
		sb.append(from+" "+to+"\n");
		count+=1;
		
		hanoi(m, from, to, n-1);
	}
}
