// 2022-08-14
// 패션왕 신혜빈

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		for(int test_case=1; test_case<=N; test_case++) {
			int M = Integer.parseInt(in.readLine());
			List<String> type = new ArrayList<>();
			int count = 1;
			
			for(int i=0; i<M; i++) {
				String[] split = in.readLine().split(" ");
				type.add(split[1]);
			}
			
			Set<String> set = new HashSet<String>(type);
			List<String> typeCnt = new ArrayList<String>(set);
			
			for(int i=0; i<typeCnt.size(); i++) {
				count*=Collections.frequency(type, typeCnt.get(i))+1;
			}
			
			System.out.println(count-1);
		}
	}
}
