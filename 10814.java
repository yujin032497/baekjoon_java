// 2022-09-19
// 나이순 정렬

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static class Person implements Comparable<Person> {
		
		int age;
		String name;
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			return this.age - o.age;
		} 
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Person> people = new ArrayList<>();
		
		int N = Integer.parseInt(in.readLine());
		
		for(int i=0; i<N; i++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			people.add(new Person(n, s));
		}
		
		
		Collections.sort(people);
		
		 for(int i=0; i<N; i++) {
			 System.out.println(people.get(i).age + " " +people.get(i).name);
		 }
	}

}
