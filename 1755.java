// 2022-10-22
// 숫자놀이

import java.io.*;
import java.util.*;
public class Main {
	
	static class Num implements Comparable<Num>{
		int N;
		String eng;
		
		public Num(int N, String eng) {
			this.N = N;
			this.eng = eng;
		}

		@Override
		public int compareTo(Num o) {
			return this.eng.compareTo(o.eng);
		}
	}

	static String[] number = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Num>list = new ArrayList<>();
		for(int i=N; i<=M; i++) {
			String n = Integer.toString(i);
			String str = "";
			for(int j=0; j<n.length(); j++) {
				int idx = n.charAt(j)-'0';
				str+=number[idx];
			}
			list.add(new Num(i,str));
		}
		
		Collections.sort(list);
		
		for(int i=1; i<=list.size(); i++) {
			sb.append(list.get(i-1).N).append(" ");
			if(i%10==0) sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
