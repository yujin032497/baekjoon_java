// 2022-08-20
// 프린터 큐

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			String[] split = in.readLine().split(" ");
			int N = Integer.parseInt(split[0]);
			int M = Integer.parseInt(split[1]);
			
			Queue<Doc> q = new LinkedList<>();
			
			split = in.readLine().split(" ");
			for(int i=0; i<N; i++) {
				q.add(new Doc(i,Integer.parseInt(split[i])));
			}
			
			int cnt = 0;
			
			while(!q.isEmpty()) {
				Doc dMax = q.stream().max(Comparator.comparingInt(Doc::getValue)).get();
				Doc d = q.poll();
				if(d.getValue()!=dMax.getValue()) {
					q.add(d);
				} else {
					cnt++;
					if(d.getNum()==M) break;
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}

class Doc {
	int num;
	int value;
	
	public Doc() {};
	public Doc(int num, int value) {
		this.num = num;
		this.value = value;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
}
