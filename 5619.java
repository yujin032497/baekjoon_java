// 2022-10-27
// 세 번째

import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] number;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		number = new int [N];
		
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(number); // 제일 작은 순으로 전체 숫자를 오름차순으로 정렬
		ArrayList<Integer> list = new ArrayList<>();
		
		if(N>4) N = 4; // 세번째로 작은 수를 찾고 싶으므로 숫자 3개정도만 받아도 무관
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				list.add(Integer.parseInt(Integer.toString(number[i]) + Integer.toString(number[j])));
			}
		}
		
		Collections.sort(list);
		System.out.println(list.get(2));
	}
}
