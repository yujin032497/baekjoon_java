// 2022-09-15
// 듣보잡

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] values = new String[N+M];
		

		
		for(int i=0; i<N+M; i++) {
			
			values[i] = in.readLine();
		}
		
		Set<String> sets = findDuplicates(values);
		ArrayList<String> list = new ArrayList<>(sets);
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(cnt);
		System.out.println(sb);
	}

	private static Set<String> findDuplicates (String[] values) {
		Set<String> seen = new HashSet<>();
		Set<String> duplicates = new HashSet<>();
		
		for(String i : values) {
			if(!seen.add(i)) {
				duplicates.add(i);
				cnt+=1;
			}
		}
		return duplicates;
		
	}

}
