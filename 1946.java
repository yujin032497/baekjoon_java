import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			ArrayList<Person> person = new ArrayList<>();
			int N = Integer.parseInt(in.readLine());
			
			for(int i=0; i<N; i++) {
				String[] split = in.readLine().split(" ");
				
				int score1 = Integer.parseInt(split[0]);
				int score2 = Integer.parseInt(split[1]);
				person.add(new Person(score1, score2));
			}
			
			Collections.sort(person);
			
			int tmp = person.get(0).MyeonScore;
			int cnt = 1;
			
			for(int i=1; i<person.size(); i++) {
				if(tmp > person.get(i).MyeonScore) {
					tmp = person.get(i).MyeonScore;
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}

}

class Person implements Comparable<Person>{
	int docScore;
	int MyeonScore;
	
	public Person() {};
	public Person(int docScore, int MyeonScore) {
		this.docScore = docScore;
		this.MyeonScore = MyeonScore;
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.docScore - o.docScore;
	}
}
