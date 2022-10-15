import java.io.*;
import java.util.*;

public class Main {

	static long A,B, ans;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		ans = 0;
		
		calc(0); // 0부터 시작
		
		System.out.println(ans);
	}

	private static void calc(long n) {
		
		if(n>B) return; // B이상은 범위 밖이므로 리턴
		
		if(n>=A && n<=B) ++ans; // 범위 안이면 +1증가
		
		calc(n*10+4); // 0부터 시작해서 자리수를 증가시키면서 +4
		calc(n*10+7); // 0부터 시작해서 자리수를 증가시키면서 +7
	}
}
