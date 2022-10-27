// 2022-10-27
// 수강 신청

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		LinkedHashSet<String> list = new LinkedHashSet<>(); // 순서대로 들어가면서 중복을 허용하지 않는다.(리스트 보다 빠르다)
		
		for(int i=0; i<L; i++) {
			String n = in.readLine();
			if(list.contains(n)) {
				list.remove(n);
			}
			list.add(n);
		}
		
		StringBuilder sb = new StringBuilder();
		for(String ret : list) {
			if(K==0) break;
			sb.append(ret).append("\n");
			K--;
		}
		
		System.out.println(sb);
	}
}
