// 2022-07-14
// ATM

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	
	static int N; //사람 수
	static int [] time; //사람별 인출하는데 걸리는 시간
	static int prev, sum; //누적 시간, 총시간
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //사람 수 입력
		
		time = new int [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			time[i] = Integer.parseInt(st.nextToken()); //사람별 인출하는데 걸리는 시간 입력
		}
		
		Arrays.sort(time);
		
		for(int i=0; i<N; i++) {
			sum += prev + time[i]; //총시간
			prev += time[i]; //
		}
		
		System.out.println(sum);
	}

}
